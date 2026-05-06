package com.onur.simplecalculator.model;

import java.util.Objects;
import java.math.BigDecimal;

public abstract class Function {

    private final String name;
    private final String symbol;
    private final boolean isUnary;
    private final int precedence;

    Function(String name, String symbol, boolean isUnary, int precedence) {
        this.name = name;
        this.symbol = symbol;
        this.isUnary = isUnary;
        this.precedence = precedence;
    }

    public abstract BigDecimal calculate(BigDecimal firstNumber, BigDecimal secondNumber);

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isUnary() {
        return isUnary;
    }

    public int getPrecedence() {
        return precedence;
    }


    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Function function = (Function) object;
        return isUnary == function.isUnary && Objects.equals(name, function.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isUnary);
    }

    @Override
    public String toString() {
        return "Function{" +
                "name='" + name + '\'' +
                ", symbol= " + symbol + '\'' +
                ", isUnary=" + isUnary +
                '}';
    }
}
