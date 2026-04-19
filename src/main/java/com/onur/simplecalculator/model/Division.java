package com.onur.simplecalculator.model;

public class Division extends Function{

    public Division() {
        super("Division", "/", false, 2);
    }

    @Override
    public double calculate(double... numbers) {

        return numbers[0] / numbers[1];
    }
}
