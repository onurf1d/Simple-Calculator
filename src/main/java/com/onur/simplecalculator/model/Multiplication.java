package com.onur.simplecalculator.model;

import java.math.BigDecimal;

public class Multiplication extends Function {

    public Multiplication() {
        super("Multiplication", "x", false, 2);
    }

    public BigDecimal calculate(BigDecimal firstNumber, BigDecimal secondNumber) {

        return firstNumber.multiply(secondNumber);
    }
}
