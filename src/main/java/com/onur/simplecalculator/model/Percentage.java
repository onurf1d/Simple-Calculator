package com.onur.simplecalculator.model;

import java.math.BigDecimal;

public class Percentage extends Function{

    public Percentage() {
        super("Percentage", "%", false, 2);
    }

    public BigDecimal calculate(BigDecimal firstNumber, BigDecimal secondNumber) {

        return firstNumber.multiply(secondNumber).divide(BigDecimal.valueOf(100));
    }
}
