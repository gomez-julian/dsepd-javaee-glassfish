package com.example.javaeehelloworld.controller.strategy;

import com.example.javaeehelloworld.decorator.polynomial.Term;

import java.util.Vector;

public class PolynomialHigher extends AbstractPolynomial{
    public PolynomialHigher(Vector<Term> terms){
        super(new StrategyHigher(), terms);
    }
}
