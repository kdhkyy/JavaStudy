package com.company;

public enum EnumSample {
    MERCY(3.302e+23, 2.439e6),
    VENUS(4.869e+24, 6.052e6);


    private final double a;
    private final double b;
    private final double surfaceGravity;

    //생성자
    EnumSample(double a, double b){
        this.a = a;
        this.b = b;
        surfaceGravity = a * b;
    }

    public double a() {return a;}
    public double b() {return b;}
    public double surfaceGravity() {return surfaceGravity;}

    public double surfaceWeight(){
        return a * surfaceGravity;
    }
}
