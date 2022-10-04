package com.example.javaeehelloworld.decorator.polynomial;

import java.util.Vector;

public class ConcreteDecoratorSimplifier extends AbstractDecoratorPolynomial{

    public ConcreteDecoratorSimplifier(AbstractPolynomial polynomial) {
        super(polynomial);
        this.evaluate();
    }

    @Override
    public Vector<Term> evaluate() {
        Vector<Term> terms = this.polynomial.evaluate();
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
        return simplifiedTerms;
    }
}
