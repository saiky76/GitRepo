package calculator;

import operator.ExpOperator;
import operator.PlusOperator;
import operator.RootOperator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Calculator implements ICalculator
{
    public static void main(String[] args) {
        //TODO: convert the input to the data returned by IUserInterface. Basically implement the IUserInterface here  - command line stuff. C
        //Can use commons command line library
        IUserInterface mockImpl = new MockUserInterfaceImpl();
        //TODO: Write the result to standout
        new Calculator().calculateResult(mockImpl.getUserInput());

    }

    public long calculateResult(List<IData> input){


        //Exp and Root are higheest precedence and can be calculated immediately as they arrive as a unit.
        //Mult and Divide are higher precedence than plus and minus and need to be calcualated as we see them and
        // store the result into stack in the first iteration
        Stack stack = new Stack();
        boolean waitingForNextOperand = false;
        Operator savedOperatorToProcess = null;
        for(IData data : input){

            if(data instanceof Operand){
                if(waitingForNextOperand){
                    Operand retrieveOperand = (Operand) stack.pop();
                    stack.push(savedOperatorToProcess.getResult(retrieveOperand, (Operand) data));
                    waitingForNextOperand  = false;
                }else{
                    stack.push(data);
                }

            }else{
                  Operator operator = (Operator) data;
                 if(PredenceOrderHelper.isOperatorSupported(operator)){
                        throw new RuntimeException();
                 }

                if(PredenceOrderHelper.isOperatorHigherPrecedence(operator)){
                    savedOperatorToProcess = operator;
                    waitingForNextOperand = true;
                    //do not push to stack
                } else if(PredenceOrderHelper.isOperatorExpOrRootThatNeedsInstantCalcualtion(operator)){
                    if(operator instanceof RootOperator{
                        stack.push(operator.getResult( ((Operator)(RootOperator)).giveOperands()));
                    }else if(operator instanceof ExpOperator {
                        stack.push(operator.getResult( (Operator)(RootOperator)).giveOperands()));
                    }
                }else{
                    stack.push(data);
                }
            }
        }



        //Now we just have plus and minus operation to process as we pop from stack

        Operand prevOperand = null;
        Operator operator = null;
        while(!stack.empty()){
            IData data = (IData)stack.pop();
            if(data instanceof Operand){
                if(prevOperand != null){
                    prevOperand = new Operand(operator.getResult(prevOperand, data));
                }else{
                    prevOperand = (Operand)data;
                }
            }
            else{
                operator = (Operator)data;
            }
        }

        return prevOperand.getValue();

    }

    private static class MockUserInterfaceImpl implements IUserInterface{

        public List<IData> getUserInput(){
            //This is just an example ofcouse....user can enter what ever he want and that gets concerted into this
            //input data list
            //TODO : On second thoughts could have gone the JSON route of doing these convertions etc
            List inputData = new ArrayList();
            inputData.add(new Operand(4));
            inputData.add(new PlusOperator('+'));
            inputData.add(new Operand(2));

            return inputData;
        }

    }

}
