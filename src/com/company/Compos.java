package com.company;

public class Compos {

    //composition -> has-a 관계
    private Immutable immutable;

    public Compos(int age, String name){
        this.immutable = new Immutable(age, name);
    }

    public Immutable getImuInfo(){
        return immutable;
    }
}
