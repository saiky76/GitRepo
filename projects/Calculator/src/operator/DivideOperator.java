package operator;

import calculator.Operand;
import calculator.Operator;


public class DivideOperator extends Operator
{

    private Object data;

    public DivideOperator(Object data) {
        this.data = data;
    }


    public long getResult(Operand ...operands){
        //TODO:
        return -1;
    }


}

