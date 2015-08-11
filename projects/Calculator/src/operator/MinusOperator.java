package calculator.operator;

import calculator.Operand;
import calculator.Operator;


public class MinusOperator extends Operator
{

    private Object data;

    public MinusOperator(Object data) {
        this.data = data;
    }


    public long getResult(Operand ...operands){
        //TODO:
        return -1;
    }


}

