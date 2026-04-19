package com.onur.simplecalculator.model;

public class Multiplication extends Function {

    public Multiplication() {
        super("Multiplication", "x", false, 2);
    }

    public double calculate(double... numbers) {

        return numbers[0] * numbers[1];
    }
}
