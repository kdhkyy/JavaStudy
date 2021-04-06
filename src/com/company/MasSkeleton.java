package com.company;

public interface MasSkeleton extends Skeleton, Skeleton2{

    //금지패턴 상수 인스턴스
    //인터페이스는 자신을 구현한 클래스의 인스턴스를 참조할 수 있는 타입 역할
    //static final double AVOGADROS_NUMBER = 6.022_100_356e23;
    //static final double ELECTRON_MASS = 9.109_383_56e31;



    Integer service(int i);
}
