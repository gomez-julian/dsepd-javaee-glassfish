package com.example.javaeehelloworld.decorator.polynomial;

import java.util.Vector;

public abstract class AbstractPolynomial {
    private Vector<Term> terms;

    protected AbstractPolynomial(){
        this.terms = new Vector<>();
    }

    protected AbstractPolynomial(Vector<Term> terms){
        this.terms = terms;
    }

    public void addTerm(Term term){
        this.terms.add(term);
    }

    public abstract Vector<Term> evaluate();

    public Vector<Term> getTerms() {
        return terms;
    }

    public void setTerms(Vector<Term> terms) {
        this.terms = terms;
    }

    @Override
    public String toString(){
        String string = "";
        for(Term term: terms) {
            String sign = (term.getCoefficient() >= 0) ? " +" : " -";
            if(term.getExponent() == 0)
                string = string
                        + sign
                        + Math.abs(term.getCoefficient());
            else
                string = string
                        + sign
                        + Math.abs(term.getCoefficient())
                        + "x"
                        + getExponentString(term.getExponent());
        }
        return string;
    }

    private String getExponentString(int exponent){
        switch (exponent) {
            case 2:
                return "\u00B2";
            case 3:
                return "\u00B3";
            case 4:
                return "\u2074";
            case 5:
                return "\u2075";
            case 6:
                return "\u2076";
            case 7:
                return "\u2077";
            case 8:
                return "\u2078";
            case 9:
                return "\u2079";
            case 0:
                return "\u2070";
            default:
                return "";
        }

    }
}
