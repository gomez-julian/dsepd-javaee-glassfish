package com.example.javaeehelloworld.controller.strategy;

import com.example.javaeehelloworld.decorator.polynomial.Term;

import javax.naming.OperationNotSupportedException;
import java.util.Vector;

public class StrategyQuadratic implements StrategyEvaluation{

    @Override
    public String evaluate(Vector<Term> trinomial) {
        String localRepresentation = null;
        try {
            if (!isTrinomialValid(trinomial))
                throw new OperationNotSupportedException();

            int a = 0, b = 0, c = 0, exponent = 0;
            for (Term term : trinomial) {
                exponent = term.getExponent();
                if (exponent == 2)
                    a = term.getCoefficient();
                if (exponent == 1)
                    b = term.getCoefficient();
                if (exponent == 0)
                    c = term.getCoefficient();
            }

            //System.out.println("a: " + a + " b:" + b + " c: " + c);

            double determinant = Math.pow(b, 2) - 4 * a * c;
            if (determinant < 0)
                throw new OperationNotSupportedException();

            double x1 = (-b + Math.sqrt(determinant)) / 2 * a;
            double x2 = (-b - Math.sqrt(determinant)) / 2 * a;

            localRepresentation = "X1: " + x1 + ", X2: " + x2;
            System.out.println(localRepresentation);


        } catch (OperationNotSupportedException e) {
            return "Trinomio no válido y respuesta imaginaria";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return localRepresentation;
    }

    private boolean isTrinomialValid(Vector<Term> trinomial){
        for(Term term: trinomial)
            if(term.getExponent() > 2)
                return false;
        return trinomial.size() < 4;
    }

}
