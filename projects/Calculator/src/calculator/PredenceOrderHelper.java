
package calculator;
import operator.DivideOperator;
import operator.ExpOperator;
import operator.MultiplyOperator;
import operator.PlusOperator;
import operator.RootOperator;

import java.util.ArrayList;
import java.util.List;

public static class PredenceOrderHelper
{

    public static boolean isOperatorSupported(Operator operator){
        //TODO:Implement it
        return true;
    }

    public static boolean isOperatorExpOrRootThatNeedsInstantCalcualtion(Operator operator){
        if(operator instanceof ExpOperator || operator instanceof RootOperator)
            return true;
        else
            return false;
    }
    }

    public static boolean isOperatorHigherPrecedence(Operator operator){
       if(operator instanceof DivideOperator || operator instanceof MultiplyOperator)
            return true;
        else
           return false;
    }
    

}
