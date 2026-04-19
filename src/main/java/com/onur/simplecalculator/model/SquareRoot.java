package com.onur.simplecalculator.model;



public class SquareRoot extends Function {

    public SquareRoot() {
        super("Square Root", "√", true, 3);
    }

    public double calculate(double... numbers) {
        if(numbers[0] < 0) {
            throw new ArithmeticException("Error: Cannot take negative number's square root!");
        }
        return Math.sqrt(numbers[0]);
    }
}
