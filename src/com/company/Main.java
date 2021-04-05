package com.company;


import java.lang.reflect.Array;
import java.math.BigInteger;
import java.time.Instant;
import java.util.Date;
import java.util.EnumSet;
import java.util.Set;


public class Main {

    public class Food {
        private final int servingSize;
        private final int servings;
        private final int calories;
        private final int fat;
        private final int sodium;
        private final int carbohydrate;

        public class Builder {
            // Required parameters(필수 인자)
            private final int svSize;
            private final int sv;

            private int calories      = 0;
            private int fat           = 0;
            private int carbohydrate  = 0;
            private int sodium        = 0;

            public Builder(int servingSize, int servings) {
                this.svSize = servingSize;
                this.sv     = servings;
            }

            public Builder calories(int val) {
                calories = val;
                return this;
            }
            public Builder fat(int val) {
                fat = val;
                return this;
            }
            public Builder carbohydrate(int val) {
                carbohydrate = val;
                return this;
            }
            public Builder sodium(int val) {
                sodium = val;
                return this;
            }
            public Food build() {
                return new Food(this);
            }
        }

        private Food(Builder builder) {
            servingSize  = builder.svSize;
            servings     = builder.sv;
            calories     = builder.calories;
            fat          = builder.fat;
            sodium       = builder.sodium;
            carbohydrate = builder.carbohydrate;
        }
    }

    enum Day{
        MONDAY, TUSDAY, WENDSDAY
    }

    public enum Car{
        n1, n2, n3
    }

    public static void main(String[] args) {

        // 1. from
        Date date = Date.from(Instant.now());
        System.out.println("date : " + date);

        // 2. of
        Set<Car> of = EnumSet.of(Car.n1, Car.n2);
        System.out.println("of : " + of);

        // 3. valueOf
        Integer a = Integer.valueOf(6);
        System.out.println("a : " + a);
        BigInteger b = BigInteger.valueOf(Integer.MAX_VALUE);
        System.out.println(b);

        // 4. instance
        Class cls = date.getClass();
        try{
            Object oo = cls.newInstance();
            System.out.println("oo : " + oo);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Object o = Array.newInstance(Car.class, 3);
        System.out.println();

        // 5. create

        // 6. getType

        // 7. new Type

        // 8 type


        EnumSet e1 = EnumSet.allOf(Day.class);
        System.out.println(e1);
        System.out.println(e1.clone());
        e1 = EnumSet.of(Day.MONDAY, Day.WENDSDAY);
        EnumSet e2 = e1.clone();
        System.out.println(e1);
        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());


        // equals 특징
        // 1. x.equals(x) = true
        // 2. x.equals(y) = true = y.equals(x) = true
        // 3. x.equals(y) = y.equals(z) = x.equals(z) = true
        // 4. x.equals(y) 를 반복적으로 호출했을때 항상 true or false 값을 리턴해야함 ?
        // 5. x.equals(null) = false 무조껀 false!!


    }

}
