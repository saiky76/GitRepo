package operator;


import calculator.Operand;
import calculator.Operator;


public class PlusOperator extends Operator
{

    private Object data;

    public PlusOperator(Object data) {
        this.data = data;
    }



    public long getResult(Operand...operands){
        //TODO:
        return -1;
    }

    public Operand[] giveOperands(){
        //TODO:
        return null;
    }



}

