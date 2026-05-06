package com.onur.simplecalculator.model;

import java.math.BigDecimal;

public class Addition extends Function {

    public Addition() {
        super("Addition", "+", false, 1);
    }

    public BigDecimal calculate(BigDecimal firstNumber, BigDecimal secondNumber) {

        return firstNumber.add(secondNumber);
    }
}
