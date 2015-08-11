package calculator;


public class Operand implements IData
{
    private int value;
    public Operand(int value){
        this.value = value;
    }

    public long getValue(){
        return value;
    }
}
