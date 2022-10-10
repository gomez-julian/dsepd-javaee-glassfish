package com.example.javaeehelloworld.controller.strategy;

import com.example.javaeehelloworld.decorator.polynomial.Term;

import java.util.Vector;

public interface StrategyEvaluation {
    public String evaluate(Vector<Term> terms);
}
