package com.example.javaeehelloworld.controller.strategy;

import com.example.javaeehelloworld.decorator.polynomial.Term;

import java.util.Vector;

public class StrategyCubical implements StrategyEvaluation{
    @Override
    public String evaluate(Vector<Term> terms) {
        return SolveCubic.resolveCubic(terms.get(0).getCoefficient(),
                terms.get(1).getCoefficient(),
                terms.get(2).getCoefficient(),
                terms.get(3).getCoefficient());
    }
}
