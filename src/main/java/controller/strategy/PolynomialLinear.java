package controller.strategy;

import java.util.Vector;

public class PolynomialLinear extends AbstractPolynomial{
    public PolynomialLinear(Vector<Term> terms){
        super(new StrategyLinear(), terms);
    }
}
