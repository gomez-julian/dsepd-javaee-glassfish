package com.example.javaeehelloworld.decorator.polynomial;

import java.util.Vector;

public class ConcreteDecoratorDerivative extends AbstractDecoratorPolynomial{
    public ConcreteDecoratorDerivative(AbstractPolynomial polynomial) {
        super(polynomial);
        this.evaluate();
    }

    @Override
    public Vector<Term> evaluate() {
        Vector<Term> initialTerms = this.polynomial.evaluate();
        Vector<Term> derivative = new Vector<>();
        for(Term term: initialTerms){
            Term derivedTerm = deriveSingleTerm(term);
            if(derivedTerm != null)
                derivative.add(derivedTerm);
        }
        this.setTerms(derivative);
        return derivative;
    }

    private Term deriveSingleTerm(Term term){
        if(term.getExponent() == 0)
            return null;
        Term derivativeTerm = new Term(term);
        derivativeTerm.setCoefficient(derivativeTerm.getCoefficient() * derivativeTerm.getExponent());
        derivativeTerm.setExponent(derivativeTerm.getExponent() - 1);
        return derivativeTerm;
    }
}
