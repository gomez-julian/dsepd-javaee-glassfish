package com.example.javaeehelloworld.controller.strategy;

import com.example.javaeehelloworld.decorator.polynomial.Term;

import java.util.Vector;

public class PolynomialQuadratic extends AbstractPolynomial{
    public PolynomialQuadratic(Vector<Term> terms){
        super(new StrategyQuadratic(), terms);
    }
}
