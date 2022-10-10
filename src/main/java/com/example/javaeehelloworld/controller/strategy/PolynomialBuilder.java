package com.example.javaeehelloworld.controller.strategy;

import com.example.javaeehelloworld.decorator.polynomial.Term;

import java.util.Vector;

public class PolynomialBuilder extends AbstractPolynomial{

    public PolynomialBuilder(){

    }

    public PolynomialBuilder(Vector<Term> terms){
        super(terms);
    }
}
