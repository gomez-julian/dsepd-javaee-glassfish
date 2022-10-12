package controller.strategy;

import java.util.Vector;

public abstract class AbstractPolynomial {
    protected Vector<Term> terms;
    protected StrategyEvaluation strategy;

    protected AbstractPolynomial(){
        this.terms = new Vector<>();
    }

    public AbstractPolynomial(StrategyEvaluation strategy) {
        this.strategy = strategy;
    }

    public StrategyEvaluation getStrategy() {
        return strategy;
    }

    public AbstractPolynomial(StrategyEvaluation strategy, Vector<Term> terms) {
        this.strategy = strategy;
        this.terms = terms;
    }

    protected AbstractPolynomial(Vector<Term> terms){
        this.terms = terms;
    }

    public void addTerm(Term term){
        this.terms.add(term);
        this.reduce();
    }

    public Vector<Term> getTerms() {
        return terms;
    }

    public void setTerms(Vector<Term> terms) {
        this.terms = terms;
    }

    public void reduce(){
        Vector<Term> terms = this.terms;
        Vector<Term> simplifiedTerms = new Vector<>();
        int [] coefficientCount = new int[10]; //Actually support only to 0-9 exponent.
        for(Term term: terms)
            coefficientCount[term.getExponent()] = coefficientCount[term.getExponent()] + term.getCoefficient();
        for(int i=9; i>=0; i--) {
            int coefficient = coefficientCount[i];
            if(coefficient != 0)
                simplifiedTerms.add(new Term(coefficient, i));
        }
        this.setTerms(simplifiedTerms);
    }

    public String evaluate(){
        return strategy.evaluate(this.getTerms());
    }

    public int getMaxExponent(){
        int exponent = 0;
        for(Term term: this.terms)
            if(term.getExponent() >= exponent)
                exponent = term.getExponent();
        return exponent;
    }

    public int getNextExponent(){
        if(this.terms.size() == 0)
            return 0;
        return this.getMaxExponent() + 1;
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
