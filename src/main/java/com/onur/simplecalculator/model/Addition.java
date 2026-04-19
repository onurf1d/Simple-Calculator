package com.onur.simplecalculator.model;

public class Addition extends Function {

    public Addition() {
        super("Addition", "+", false, 1);
    }

    public double calculate(double... numbers) {

        return numbers[0] + numbers[1];
    }
}
