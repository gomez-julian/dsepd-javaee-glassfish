package com.example.javaeehelloworld.controller.strategy;

public class SolveCubic {

    private static double[] solveCubic(double d, double a, double b, double c) {
        double[] result;
        if (d != 1) {
            a = a / d;
            b = b / d;
            c = c / d;
        }

        double p = b / 3 - a * a / 9;
        double q = a * a * a / 27 - a * b / 6 + c / 2;
        double D = p * p * p + q * q;

        if (Double.compare(D, 0) >= 0) {
            if (Double.compare(D, 0) == 0) {
                double r = Math.cbrt(-q);
                result = new double[2];
                result[0] = 2 * r;
                result[1] = -r;
            } else {
                double r = Math.cbrt(-q + Math.sqrt(D));
                double s = Math.cbrt(-q - Math.sqrt(D));
                result = new double[1];
                result[0] = r + s;
            }
        } else {
            double ang = Math.acos(-q / Math.sqrt(-p * p * p));
            double r = 2 * Math.sqrt(-p);
            result = new double[3];
            for (int k = -1; k <= 1; k++) {
                double theta = (ang - 2 * Math.PI * k) / 3;
                result[k + 1] = r * Math.cos(theta);
            }

        }
        for (int i = 0; i < result.length; i++) {
            result[i] = result[i] - a / 3;
        }
        return result;
    }


    private static double[] solveCubic(double a, double b, double c) {
        double d = 1;
        return solveCubic(a, b, c, d);
    }

    public static String resolveCubic(double d, double a, double b, double c){
        double[] result = solveCubic(d, a, b, c);
        String stringResult = "";
        for (int i = 0; i < result.length; i++) {
            stringResult = stringResult + "X= " + result[i] + "; ";
        }
        return stringResult;
    }

    public static void main(String args[]) {
        double[] result = solveCubic(5, 4, 3, 2);
        for (double aResult : result) {
            System.out.println(aResult);
        }
    }
}
