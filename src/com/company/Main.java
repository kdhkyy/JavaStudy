package com.company;

import com.company.TagClass.Circle;

import javax.jws.soap.SOAPBinding;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;


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
        System.out.println("14 : 오름 차순 정렬전 : " + pointList.toString());
        Collections.sort(pointList);
        System.out.println("14 : 오름 차순 정렬후 : " + pointList.toString());

        // 15. public 클래스에서는  public 필드가아닌 접근자 메서드를 사용
        Point p = new Point();
        p.setX(13);
        p.setY(55);
        System.out.println(p.toString());
        System.out.println("15 : Point = x "+p.getX()+" : y "+p.getY());


        // 16. 변경 가능성의 최소화
        // 클래스 확장 X
        // 모든 필드 final
        // 모든 필드 private
        // 자신 이외에 가변 컴포넌트 접근 X
        Immutable imu = new Immutable(13, "json");
        System.out.println("16 : " + imu);
        Immutable imu2 = Immutable.valueOf(25, "Willson");
        System.out.println("16 : " + imu2);

        // 17. 상속보단 컴포지션 사용
        Compos com = new Compos(99, "noname");
        imu = com.getImuInfo();
        System.out.println("17 : " + imu);

        // 18. 상속을 고려하지 않은 클래스는 상속을 금지시킴
        // 금지방법 : final 활용
        //         모든 생성자를 private로 선언, public static factory method로 만드는 방법

        // 19. 추상 클래스보다는 인터페이스를 우선
        InterfaceTest inter = new InterfaceTest();
        System.out.println("19 : " + inter.service(6));
        System.out.println("19 : " + inter.sub(5));
        System.out.println("19 : " + inter.sum(33));

        // 20. 인터페이스는 타입을 정의하는 용도로 쓰여야한다.
        // 21. 인터페이스는 구현하는 쪽을 생각하고 설계하라.
        // MaskSkeleton.java

        // 22. 태그달린 클래스보다 클래스 계층구조를 활용하라
        // TagClass.class 를 클래스 계층구조로 단순히 바꾸는 것은 어렵지 않지만 앞의 내용에 따라 (item 16 -> 접근자 메서드 권장)을 지켜서 만든 건지에 대한 확인 필요
        //TagClass tc = new TagClass();
        //System.out.println("21 : Circle - " + tc.new Circle(1.3).section());
        //System.out.println("21 : Rectangle - " + tc.new Rectangle(1.6, 5.5).section());

        //OUTPUT
        // Circle - 5.3092915845667505
        // Rectangle - 8.8


        // 23. 맴버 클래스는 되도록 static으로 만들자
        System.out.println("23 : " + new TagClass.Circle(11.2).section());
        System.out.println("23 : " + new TagClass.Rectangle(1.6, 5.5).section());

        // 24. 톱클래스는 한파일에 하나만
        // Desert.java [
        //      private static Desert {...}
        //      private static Milk {...}  <- 이 짓거리 하지 말라는 의미 라고 생각
        //[

        // 25. 로 타입 사용하지말것
        // List<E> raw타입
        // List<?> wildcard타입 -> List<? extends Object>
        List l = new ArrayList();
        List<? extends Object> l2 = new ArrayList<>();


        // 26.비검사 경고를 제거하라
        // Generic을 사용 하면서 최대한 많은 비검사 경고를 제거해 주는 것이 좋다. 앵간하면 다 ...?
        // ClassCastException 발생 가능성을 가지고있음
        // @SuppressWarnings("unchecked") 어노테이션으로 경고를 숨기는 방법또한 있으며 숨길 때는 주석으로 근거를 남긴다...?

        Map<?,?> map = new HashMap<>();


        // 27. 배열보다는 리스트를 사용해라
        // Object[] objectArray = new Long[1];
        // objectArray[0] = "타입이 달라서 넣을 수 없음";
        // OutPut
        // Exception in thread "main" java.lang.ArrayStoreException: java.lang.String
        // 	 at com.company.Main.main(Main.java:190)
        // 배열은 제네릭타입, 매개변수화타입, 타입 매개변수로 사용이 안댐


        // 28. 이왕이면 제네릭 타입으로 만들어라
        // 29. 제네릭 메서드로 만들어라

        // 그러면 결국엔 <E> Element 와 <T> Type 의 차이는 무엇이며 어느때 사용하는가...?
        // 제네릭 타입 ->   
        // 제네릭 메서드 -> 리턴타입 변수 = <구체적 타입>메소드명(매개값);

        // 상수열거타입  enum
        // 열거 타입은 각 상수가 인스턴스를 하나씩 만들어 public static final 필드로 제공한다
        // 즉 인스턴스가 통제됨, 싱글턴(Singleton)은 원소가 하나뿐인 열거타입 이라고 볼 수도 있음
        //

    }
    public enum Apple{ EUJI, PIPPIN, GRANNY_SMITH}
}
