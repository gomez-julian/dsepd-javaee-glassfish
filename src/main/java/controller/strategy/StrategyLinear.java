package controller.strategy;

import java.util.Vector;

public class StrategyLinear implements StrategyEvaluation{
    @Override
    public String evaluate(Vector<Term> terms) {
        int x = 0,c = 0;
        for(Term term: terms){
            if(term.getExponent()==1)
                x = term.getCoefficient();
            if(term.getExponent()==0)
                c = term.getCoefficient();
        }
        double result = (c * -1)/x;
        return "Resultado: X= " + result;
    }
}
