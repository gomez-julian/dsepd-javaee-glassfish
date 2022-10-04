package com.example.javaeehelloworld.decorator.polynomial;

//TODO: REMOVE isPositive VALUE BECAUSE ITS REDUNDANT
public class Term {
    private int coefficient, exponent;

    public Term(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public Term(Term term){
        this.coefficient = term.getCoefficient();
        this.exponent = term.getExponent();
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

}
