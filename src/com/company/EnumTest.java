package com.company;

import java.util.Arrays;
import java.util.Collection;

public class EnumTest {
    public static void main(String[] args) {
        for(EnumSample sam : EnumSample.values()){
            System.out.println(" " + sam + " : " + sam.surfaceWeight());
        }

        System.out.println("PLUS : "+EnumSample2.PLUS.apply(1.3,3.3));

        //test(EnumSample2.class, 1.3, 1.4);
        test(Arrays.asList(EnumSample2.values()), 1.3, 1.4);
        System.out.println("value : " + Arrays.asList(EnumSample2.values()));
    }

    /*private static <T extends Enum<T> & Operation> void test(Class<T> enumType, double a, double b){
        for(Operation op : enumType.getEnumConstants()){
            System.out.printf("%f  %s  %f = %f%n", a, op.toString(), b, op.apply(a, b));
        }
    }*/

    private static void test(Collection<? extends Operation> opSet, double a, double b){
        for(Operation op : opSet){
            System.out.printf("%f  %s  %f = %f%n", a, op.toString(), b, op.apply(a, b));
        }
    }
}
