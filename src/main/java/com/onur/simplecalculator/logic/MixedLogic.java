package com.onur.simplecalculator.logic;

import java.util.Stack;
import com.onur.simplecalculator.model.*;
import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.math.BigDecimal;

public class MixedLogic {

    private Stack<BigDecimal> operandStack = new Stack<>();

    private Stack<Function> operatorStack = new Stack<>();

    private Map<String, Function> functionMap = new HashMap<>();

    public MixedLogic() {
        functionMap.put("+", new Addition());
        functionMap.put("-", new Subtraction());
        functionMap.put("x", new Multiplication());
        functionMap.put("/", new Division());
        functionMap.put("%", new Percentage());
    }

    public BigDecimal calculate(String text) {
        operandStack.clear();
        operatorStack.clear();

        StringTokenizer st = new StringTokenizer(text, " ");

        while (st.hasMoreTokens()) {
            String currentToken = st.nextToken();

            if (currentToken.matches("-?\\d+(\\.\\d+)?")) {
                operandStack.push(new BigDecimal(currentToken));
            }

            else if(functionMap.containsKey(currentToken)) {
                Function relatedFunction = functionMap.get(currentToken);

                while(!operatorStack.empty() && operatorStack.peek().getPrecedence() >= relatedFunction.getPrecedence()) {
                    executeTopOperator();
                }

                operatorStack.push(relatedFunction);
            }

        }
//        while (!operatorStack.empty()) {
//            executeTopOperator();
//        }
        while (!operatorStack.empty()) {
            if (operandStack.size() >= 2) {
                executeTopOperator();
            } else {
                break;
            }
        }
//        return operandStack.pop();
        return operandStack.isEmpty() ? BigDecimal.ZERO : operandStack.pop();
    }

    private void executeTopOperator() {
        Function function = operatorStack.pop();
        BigDecimal secondElement = operandStack.pop();
        BigDecimal firstElement = operandStack.pop();
        BigDecimal result = function.calculate(firstElement, secondElement);
        operandStack.push(result);
    }

}
