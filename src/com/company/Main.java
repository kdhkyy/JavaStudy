package com.company;

import java.util.*;



public class Main {

    enum cc{
        TEST1, TEST2, TEST3
    }


    public static class Worker implements AutoCloseable{

        @Override
        public void close() throws Exception {
             throw new RuntimeException("EXEPTION!! - CLOSE");
        }

        public String work(){
            throw new RuntimeException("EXEPTION - WORK");
        }
    }


    public static void main(String[] args) throws Exception {

        // 1. from
        Car car = Car.from("sam");
        System.out.println("1 : "+car.getCarName());

        // 2. of
        EnumSet res = Car.of(cc.TEST1, cc.TEST2);
        System.out.println("2 : "+res);

        // 3. valueOf
        Enum res3 = cc.valueOf("TEST1");
        System.out.println("3 : "+res3);

        Enum res4 = cc.valueOf(cc.TEST3.toString());
        System.out.println("4 : "+res4);

        // 4. instance
        // 매개변수로 명시한 인스턴스를 반환하지만 같은 인스턴스임을 보장하지는 않는다(같은 인스턴스임을 보장하지 않는다라함은....??)
        System.out.println("4 : 호출전 : " + car.hashCode());
        Car res5 = Car.getInstance();
        System.out.println("4 : 호출후 : " + res5.hashCode());

        // 5. create
        Car res6 = Car.newInstance();
        System.out.println("5 : new 호출 후 : "+ res6.hashCode());

        // 6. getType
        Car res7 = Car.getCar();
        System.out.println("6 : getType : "+ res7.hashCode());

        // 7. new Type
        Car res8 = Car.newCar("뉴카");
        System.out.println("newType : " + res8.hashCode());
        System.out.println("name : "+ res8.getCarName());

        // 8. type -> 정확히 이해되지 않는부분 간결한 버전이 무엇을 말하는건지 ...음 ..
        ArrayList res9 = Car.list(cc.TEST1);
        System.out.println(res9);

        // 9. Builder Pattern
        Food food = new Food.Builder(1,2).fat(2).calories(3).sodium(34).build();
        System.out.println(food.getInfo());

        // 10. Cleaner / try with resources
//        try(Worker worker = new Worker()){
//            worker.close();
//        }

        // 11. equals 재정의
        String rr = "";
        System.out.println("Car클래스에서 재정의 : " + res8.equals(res7));
        System.out.println("String 클래스의 equals : " + rr.equals(res7));

        System.out.println("hashCode : " + res8.hashCode());

        // 12. toString
        res8.setPhone("010-2341-1234");
        res8.setCarName("what");
        res8.setNumber(14);
        System.out.println(res8.toString());


    }

}
