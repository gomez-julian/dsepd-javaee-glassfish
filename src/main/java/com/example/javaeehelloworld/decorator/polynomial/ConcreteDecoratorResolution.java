package com.example.javaeehelloworld.decorator.polynomial;

import javax.naming.OperationNotSupportedException;
import java.util.Vector;

public class ConcreteDecoratorResolution extends AbstractDecoratorPolynomial {

    private String representation;

    public ConcreteDecoratorResolution(AbstractPolynomial polynomial) {
        super(polynomial);
        this.evaluate();
    }

    //Solo realiza la resolución de un trinomio por la fórmula general
    @Override
    public Vector<Term> evaluate() {
        Vector<Term> trinomial = this.polynomial.evaluate();
        try {
            if(!isTrinomialValid(trinomial))
                throw new OperationNotSupportedException();

            int a = 0,b = 0,c = 0, exponent= 0;
            for(Term term: trinomial){
                exponent = term.getExponent();
                if(exponent == 2)
                    a = term.getCoefficient();
                if(exponent == 1)
                    b = term.getCoefficient();
                if(exponent == 0)
                    c = term.getCoefficient();
            }

            //System.out.println("a: " + a + " b:" + b + " c: " + c);

            double determinant = Math.pow(b,2) - 4 * a * c;
            if(determinant < 0)
                throw new OperationNotSupportedException();

            double x1 = (-b + Math.sqrt(determinant)) / 2* a;
            double x2 = (-b - Math.sqrt(determinant)) / 2* a;

            System.out.println("Resolución del trinomio " + this.polynomial + " por fórmula general");

            String localRepresentation = "X1: " + x1 + ", X2: " + x2;
            System.out.println(localRepresentation);
            System.out.println("Decorador regresando el polinomio original...");
            this.setTerms(trinomial);
            this.representation = localRepresentation;


        }catch (OperationNotSupportedException e){
            System.out.println("Trinomio no válido y respuesta imaginaria: " + this.polynomial);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return trinomial;
    }

    private boolean isTrinomialValid(Vector<Term> trinomial){
        for(Term term: trinomial)
            if(term.getExponent() > 2)
                return false;
        return trinomial.size() < 4;
    }

    @Override
    public String toString(){
        return this.representation;
    }
}
