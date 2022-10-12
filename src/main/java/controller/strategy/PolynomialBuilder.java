package controller.strategy;

import java.util.Vector;

public class PolynomialBuilder extends AbstractPolynomial{

    private static PolynomialBuilder polynomialBuilder = new PolynomialBuilder();

    public static PolynomialBuilder getBuilder(){
        return polynomialBuilder;
    }

    public PolynomialBuilder(){

    }

    public PolynomialBuilder(Vector<Term> terms){
        super(terms);
    }
}
