package com.company;

import java.util.function.DoubleBinaryOperator;

public enum EnumSample2 implements Operation{
//public enum EnumSample2{
    /*PLUS("+"){
        @Override
        public double apply(double a, double b) {
            return a+b;
        }
    },
    MINUS("-"){
        @Override
        public double apply(double a, double b) {
            return a-b;
        }
    },
    TIMES("*"){
        @Override
        public double apply(double a, double b) {
            return a*b;
        }
    },
    DIVIDE("/") {
        @Override
        public double apply(double a, double b) {
            return a/b;
        }
    };*/
    PLUS("+",(x,y) -> x + y),
    MINUS("-", (x,y) -> x - y),
    TIMES("*", (x,y) -> x * y),
    DIVIDE("/", (x,y) -> x * y);

    private final String symbol;
    private final DoubleBinaryOperator doubleBinaryOperator;

    private EnumSample2(String symbol, DoubleBinaryOperator doubleBinaryOperator) {
        this.symbol = symbol;
        this.doubleBinaryOperator = doubleBinaryOperator;
    }

    @Override
    public String toString() {
        return symbol;
    }

    @Override
    public double apply(double a, double b) {
        return doubleBinaryOperator.applyAsDouble(a, b);
    }
}
