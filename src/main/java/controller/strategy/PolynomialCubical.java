package controller.strategy;

import java.util.Vector;

public class PolynomialCubical extends AbstractPolynomial{
    public PolynomialCubical(Vector<Term> terms){
        super(new StrategyCubical(), terms);
    }
}
