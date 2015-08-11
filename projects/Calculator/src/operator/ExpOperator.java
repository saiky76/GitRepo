package operator;

import calculator.Operand;
import calculator.Operator;


public class ExpOperator extends Operator
{

    private Object data;

    public ExpOperator(Object data) {
        this.data = data;
    }


    public long getResult(Operand ...operands){
        //TODO:
        //do something with the object in the data variable
        return -1;
    }

}

