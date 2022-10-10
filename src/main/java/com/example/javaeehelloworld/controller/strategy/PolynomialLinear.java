package com.example.javaeehelloworld.controller.strategy;

import com.example.javaeehelloworld.decorator.polynomial.Term;

import java.util.Vector;

public class PolynomialLinear extends AbstractPolynomial{
    public PolynomialLinear(Vector<Term> terms){
        super(new StrategyLinear(), terms);
    }
}
