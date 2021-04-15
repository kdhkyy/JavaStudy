package com.company;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.DoubleBinaryOperator;

public class EnumTest {
    public static void main(String[] args) throws NoSuchMethodException {
        for(EnumSample sam : EnumSample.values()){
            System.out.println(" " + sam + " : " + sam.surfaceWeight());
        }

        System.out.println("PLUS : "+EnumSample2.PLUS.toString());

        //test(EnumSample2.class, 1.3, 1.4);
//        test(Arrays.asList(EnumSample2.values()), 1.3, 1.4);
        System.out.println(EnumSample2.PLUS.apply(1.3,1.4));
        System.out.println("value : " + Arrays.asList(EnumSample2.values()));
        test(EnumSample2.class, 1.3, 1.4 );
    }

    private static <T extends Enum<T> & Operation> void test(Class<T> enumType, double a, double b){
        for(Operation op : enumType.getEnumConstants()){
            System.out.printf("%f  %s  %f = %f%n", a, op.toString(), b, op.apply(a, b));
        }
    }

}
