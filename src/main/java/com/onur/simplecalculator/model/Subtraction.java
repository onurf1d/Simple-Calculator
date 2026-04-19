package com.onur.simplecalculator.model;

public class Subtraction extends Function{

    public Subtraction() {
        super("Subtraction", "-", false, 1);
    }

    public double calculate(double... numbers) {



        return numbers[0] - numbers[1];
    }
}
