package com.example.javaeehelloworld.controller.strategy;

import com.example.javaeehelloworld.decorator.polynomial.Term;

import java.util.Vector;

public class PolynomialCubical extends AbstractPolynomial{
    public PolynomialCubical(Vector<Term> terms){
        super(new StrategyCubical(), terms);
    }
}
