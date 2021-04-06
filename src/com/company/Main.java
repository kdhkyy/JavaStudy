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
        // 반환 = method
        Car res7 = Car.getCar();
        System.out.println("6 : getType : "+ res7.hashCode());

        // 7. new Type
        // 반환 = method
        Car res8 = Car.newCar("뉴카");
        System.out.println("newType : " + res8.hashCode());
        System.out.println("name : "+ res8.getCarName());

        // 8. type -> 정확히 이해되지 않는부분 간결한 버전이 무엇을 말하는건지 ...음 ..
        // Class = 사용자 정의 타입
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
        System.out.println("11 : Car클래스에서 재정의 : " + res8.equals(res7));
        System.out.println("11 : String 클래스의 equals : " + rr.equals(res7));

        System.out.println("11 : hashCode : " + res8.hashCode());

        // 12. toString
        res8.setPhone("010-2341-1234");
        res8.setCarName("what");
        res8.setNumber(14);
        System.out.println("12 : " + res8.toString());

        // 13. Cloneable
        // x.clone != x
        // x.clone.getClass() == x.getClass()
        Car clsClone = (Car) res8.clone();
        if(clsClone.getClass() == res8.getClass()){
            System.out.println();
            System.out.println("13 : clone success");
        }else{
            System.out.println("13 : clone fail");
        }

        // 14. Comparable
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(1, 3));
        pointList.add(new Point(15, 1));
        pointList.add(new Point(15, 33));
        pointList.add(new Point(90, 2));
        System.out.println("오름 차순 정렬전 : " + pointList.toString());
        Collections.sort(pointList);
        System.out.println("오름 차순 정렬후 : " + pointList.toString());

        // 15. public 클래스에서는  public 필드가아닌 접근자 메서드를 사용
        Point p = new Point();
        p.setX(13);
        p.setY(55);
        System.out.println(p.toString());
        System.out.println("Point = x "+p.getX()+" : y "+p.getY());


        // 16. 변경 가능성의 최소화
        // 클래스 확장 X
        // 모든 필드 final
        // 모든 필드 private
        // 자신 이외에 가변 컴포넌트 접근 X
        Immutable imu = new Immutable(13, "json");
        System.out.println(imu);
        Immutable imu2 = Immutable.valueOf(25, "Willson");
        System.out.println(imu2);

        // 17. 상속보단 컴포지션 사용
        Compos com = new Compos(99, "noname");
        imu = com.getImuInfo();
        System.out.println(imu);

        // 18. 상속을 고려하지 않은 클래스는 상속을 금지시킴
        // 금지방법 : final 활용
        //         모든 생성자를 private로 선언, public static factory method로 만드는 방법

        // 19. 추상 클래스보다는 인터페이스를 우선
        InterfaceTest inter = new InterfaceTest();
        System.out.println(inter.service(6));
        System.out.println(inter.sub(5));
        System.out.println(inter.sum(33));

        // 20. 인터페이스는 타입을 정의하는 용도로 쓰여야한다.
        // MaskSkeleton

        // 21.
    }
}
