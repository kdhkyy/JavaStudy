package com.company;


import sun.security.jca.GetInstance;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.time.Instant;
import java.util.*;

import static sun.security.jca.GetInstance.*;


public class Main {

    enum cc{
        TEST1, TEST2, TEST3
    }

    public static void main(String[] args) {

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
        System.out.println("호출전 : " + car.hashCode());
        Car res5 = Car.getInstance();
        System.out.println("호출후 : " + res5.hashCode());

        // 5. create
        Car res6 = Car.newInstance();
        System.out.println("new 호출 후 : "+ res6.hashCode());

        // 6. getType
        Car res7 = Car.getCar();
        System.out.println("getType : "+ res7.hashCode());

        // 7. new Type
        Car res8 = Car.newCar("뉴카");
        System.out.println("newType : " + res8.hashCode());
        System.out.println("name : "+ res8.getCarName());

        // 8 type -> 정확히 이해되지 않는부분 간결한 버전이 무엇을 말하는건지 ...음 ..
        ArrayList res9 = Car.list(cc.TEST1);
        System.out.println(res9);

    }

}
