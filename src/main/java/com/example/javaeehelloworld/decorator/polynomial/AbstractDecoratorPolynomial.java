package com.example.javaeehelloworld.decorator.polynomial;

public abstract class AbstractDecoratorPolynomial extends AbstractPolynomial{

    protected AbstractPolynomial polynomial;

    public AbstractDecoratorPolynomial(AbstractPolynomial polynomial){
        this.polynomial = polynomial;
    }
}
