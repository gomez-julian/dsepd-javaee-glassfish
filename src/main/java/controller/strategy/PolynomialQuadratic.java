package controller.strategy;

import java.util.Vector;

public class PolynomialQuadratic extends AbstractPolynomial{
    public PolynomialQuadratic(Vector<Term> terms){
        super(new StrategyQuadratic(), terms);
    }
}
