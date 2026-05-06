package com.onur.simplecalculator.model;

import java.math.BigDecimal;

public class Division extends Function{

    public Division() {
        super("Division", "/", false, 2);
    }

    @Override
    public BigDecimal calculate(BigDecimal firstNumber, BigDecimal secondNumber) {

        return firstNumber.divide(secondNumber);
    }
}
