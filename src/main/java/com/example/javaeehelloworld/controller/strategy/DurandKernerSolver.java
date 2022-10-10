package com.example.javaeehelloworld.controller.strategy;
import java.util.ArrayList;

public class DurandKernerSolver {
    private complexNumber[] coefficients;
    private int count = 0;
    private ArrayList<complexNumber> roots = new ArrayList<>();
    private int numOfRoots;

    private DurandKernerSolver(complexNumber[] coefficients) {
        super();
        this.coefficients = coefficients;
        numOfRoots = coefficients.length;
        double radius = getRadius();
        double theta = (Math.PI * 2.0) / ((double) numOfRoots);
        double offset = theta / 4.0;
        for (int a = 0; a < numOfRoots; a++) {
            double real = radius * Math.cos(a * theta + offset);
            double imaginery = radius * Math.sin(a * theta + offset);
            roots.add(new complexNumber(real, imaginery));
        }
    }

    private double getRadius() {
        return Math.pow(coefficients[coefficients.length - 1].abs(), (1.0 / ((double) numOfRoots)));
    }

    private complexNumber solvePX(complexNumber x) {
        int power = coefficients.length;
        complexNumber output = new complexNumber(0, 0);
        while (power >= 0) {
            if (coefficients.length - power == 0) {
                output = output.add(x.pow(power));
            } else {
                output = output.add(coefficients[coefficients.length - power - 1].multiply(x.pow(power)));
            }
            power--;
        }
        return output;
    }

    private complexNumber Denominator(int root, complexNumber x) {
        complexNumber output = null;
        for (int a = 1; a <= numOfRoots; a++) {
            if (a != root) {
                if (output == null) {
                    output = x.subtract(roots.get((count) * numOfRoots + a - 1));
                } else {
                    output = output.multiply(x.subtract(roots.get((count) * numOfRoots + a - 1)));
                }
            }
        }
        return output;
    }

    private complexNumber findNext(int root) {
        complexNumber x = roots.get((count) * numOfRoots + root - 1);
        complexNumber nominator = solvePX(x);
        complexNumber denominator = Denominator(root, x);
        complexNumber ratio = nominator.divide(denominator);
        return x.subtract(ratio);
    }

    private void iterate() {
        for (int a = 1; a <= numOfRoots; a++) {
            roots.add(findNext(a));
        }
        count++;
    }

    // Public facing method of this implementation. Parameters are the
    // coefficients for each term in the polynomial. First parameter is
    // is the real number part of each coefficient, second parameter
    // is imaginary part of each coefficient. Will return a 2d array
    // of the roots of the polynomial, with each root as a complex number;
    // the first array is the real part of each root, and the second array
    // is the imaginary part of each root. Will throw
    // IllegalArgumentException if both parameter arrays do not equal each
    // other, or are less than 3 elements in length.
    public static double[][] solvePolynomial(double[] realCoEf, double[] imagCoEf) {
        if (realCoEf.length != imagCoEf.length || realCoEf.length < 3) {
            throw new IllegalArgumentException("Invalid parameters for coefficients");
        }
        complexNumber highestCoefficient = new complexNumber(realCoEf[0], imagCoEf[0]);
        complexNumber[] coefficients = new complexNumber[realCoEf.length - 1];
        for (int a = 0; a < coefficients.length; a++) {
            coefficients[a] = (new complexNumber(realCoEf[a + 1], imagCoEf[a + 1])).divide(highestCoefficient);
        }

        DurandKernerSolver temp = new DurandKernerSolver(coefficients);

        boolean changedMuch = true;
        double error = Math.pow(10, -8);
        while (changedMuch) {
            temp.iterate();
            if (temp.count > 10) {

                changedMuch = false;
                for (int a = 0; a < temp.numOfRoots; a++) {
                    complexNumber difference = temp.roots.get(temp.count * temp.numOfRoots + a)
                            .subtract(temp.roots.get((temp.count - 1) * temp.numOfRoots + a));
                    if (Math.abs(difference.realConstant) > error || Math.abs(difference.imagineryConstant) > error) {
                        changedMuch = true;
                        a = temp.numOfRoots;
                    }
                }
            }
        }

        double[][] output = new double[2][temp.numOfRoots];
        for (int a = 0; a < temp.numOfRoots; a++) {
            output[0][a] = temp.roots.get(temp.count * temp.numOfRoots + a).realConstant;
            output[1][a] = temp.roots.get(temp.count * temp.numOfRoots + a).imagineryConstant;
        }
        return output;
    }

    private static class complexNumber {
        private double realConstant;
        private double imagineryConstant;

        private complexNumber(double realConstant, double imagineryConstant) {
            super();
            this.realConstant = realConstant;
            this.imagineryConstant = imagineryConstant;
        }

        private complexNumber add(complexNumber other) {
            return new complexNumber(realConstant + other.realConstant, imagineryConstant + other.imagineryConstant);
        }

        private complexNumber subtract(complexNumber other) {
            return new complexNumber(realConstant - other.realConstant, imagineryConstant - other.imagineryConstant);
        }

        private complexNumber multiply(complexNumber other) {
            return new complexNumber(realConstant * other.realConstant - imagineryConstant * other.imagineryConstant,
                    realConstant * other.imagineryConstant + imagineryConstant * other.realConstant);
        }

        private complexNumber conjugate() {
            return new complexNumber(realConstant, -imagineryConstant);
        }

        private complexNumber divide(complexNumber other) {
            complexNumber conjugate = other.conjugate();
            complexNumber nominator = this.multiply(conjugate);
            double denominator = other.multiply(conjugate).realConstant;
            return new complexNumber(nominator.realConstant / denominator, nominator.imagineryConstant / denominator);
        }

        private complexNumber pow(int power) {
            if (power == 0) {
                return new complexNumber(1, 0);
            } else {
                complexNumber temp = this;
                while (power - 1 > 0) {
                    temp = temp.multiply(this);
                    power--;
                }
                return temp;
            }
        }

        private double abs() {
            return Math.hypot(realConstant, imagineryConstant);
        }

    }

    public static void main(String[] args) {
        double[] real = new double[] {1, 0, -5, 0, 4};
        // Real parts of each coefficient of the polynomial.
        // If term in polynomial has 0 as coefficient put 0 in real
        // and imaginary part.
        double[] imag = new double[] {0, 0, 0, 0, 0};
        // Imaginary part of coefficient.
        double[][] temp = DurandKernerSolver.solvePolynomial(real, imag);
        for(int a = 0; a < temp[0].length; a++) {
            System.out.println(temp[0][a] + " " + temp[1][a] + "I");
        }
    }
}
