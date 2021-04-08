package com.company;

public enum EnumSample3 implements Operation{
    EXP("^"){
        @Override
        public double apply(double a, double b) {
            return a*b;
        }
    },
    REMAINDER("%"){
        @Override
        public double apply(double a, double b) {
            return a%b;
        }
    };

    private final String symbol;

    private EnumSample3(String symbol){
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
