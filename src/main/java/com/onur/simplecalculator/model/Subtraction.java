package com.onur.simplecalculator.model;

import java.math.BigDecimal;

public class Subtraction extends Function{

    public Subtraction() {
        super("Subtraction", "-", false, 1);
    }

    public BigDecimal calculate(BigDecimal firstNumber, BigDecimal secondNumber) {

        return firstNumber.subtract(secondNumber);
    }
}
