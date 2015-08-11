package calculator;

public abstract class Operator implements IData
{
    public abstract long getResult(Operand ...operands);
}
