package com.onur.simplecalculator.model;

public class Percentage extends Function{

    public Percentage() {
        super("Percentage", "%", false, 2);
    }

    public double calculate(double... numbers) {
        return (numbers[0] * numbers[1]) / 100;
    }
}
