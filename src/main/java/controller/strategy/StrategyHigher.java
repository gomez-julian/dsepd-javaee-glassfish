package controller.strategy;

import java.util.Vector;

public class StrategyHigher implements StrategyEvaluation{
    @Override
    public String evaluate(Vector<Term> terms) {
        double [] coefficients = new double[terms.size()];
        double [] imaginaries = new double[terms.size()];
        for (int i = 0; i < terms.size(); i++)
            coefficients[i] = terms.get(i).getCoefficient();

        double[][] temp = DurandKernerSolver.solvePolynomial(coefficients, imaginaries);
        String result = "";
        for(int a = 0; a < temp[0].length; a++) {
            System.out.println(temp[0][a] + " " + temp[1][a] + "I");
            result = result + "X= " + temp[0][a] + "; ";
            result = result + "X= -" + temp[0][a] + "; ";
        }
        //return new PolynomialBuilder(terms).toString();
        return result;
    }

}
