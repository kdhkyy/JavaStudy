package com.company;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Stream;

public class Test2 {
    public static class Bird{
        private int a;
        public Bird(int a){
            this.a = a;
            fly();
        }

        public void fly(){
            System.out.println("I can fly");
        }
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
       Bird bird = new Bird(3);
       Seet(bird);

       String[] arr = new String[]{"a", "b", "c"};
       Stream<String> stream = Arrays.stream(arr);
       Stream<String> stream2 = Arrays.stream(arr, 1, 2);
        System.out.println(stream2);
    }

    public static void Seet(Object o) throws InvocationTargetException, IllegalAccessException {
        Class<?> clazz = o.getClass();
        Method[] methods = clazz.getMethods();
        for(Method method : methods){
            if(method.getName().equals("fly")) {
                method.invoke(o,null);
            }
        }


    }

    //annotation에 다는 annotation -> meta annotation



}
