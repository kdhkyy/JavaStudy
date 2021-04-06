package com.company;

import com.sun.org.apache.bcel.internal.generic.IMUL;

public class Immutable {
    private final int age;
    private final String name;

    public Immutable(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public static Immutable valueOf(int age, String name){
        return new Immutable(age, name);
    }

    @Override
    public String toString() {
        return "Immutable[" +
                "age=" + age +
                ", name='" + name + '\'' +
                ']';
    }

}
