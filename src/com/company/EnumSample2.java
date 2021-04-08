package com.company;

public enum EnumSample2 implements Operation{
    PLUS("+"){
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
    };

    private final String symbol;

    private EnumSample2(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

}
