package controller.strategy;

import java.util.Vector;

public class PolynomialHigher extends AbstractPolynomial{
    public PolynomialHigher(Vector<Term> terms){
        super(new StrategyHigher(), terms);
    }
}
