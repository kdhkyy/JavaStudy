package com.company;

public class InterfaceTest implements MasSkeleton {

    //private InterfaceTest(){}  인스턴스화 방지test

    @Override
    public Integer service(int i) {
        return i;
    }

    @Override
    public Integer sum(int i) {
        return i+2;
    }

    @Override
    public Integer sub(int i) {
        return i-2;
    }
}
