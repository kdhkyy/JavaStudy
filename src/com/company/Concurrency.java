package com.company;

import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Concurrency {

    private static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        // 스레드는 여러활동을 동시에 수행가능하지만 동시성 프록그래밍은 단일 스레드 프로그래밍보다 어렵다?
        // 멀티코어 프로세스를 제대로 활용하려면 이걸 알고 있어야한다.
        // 동기화 없이는 a스레드가 동작한 내용(만들어낸 변화)을(를) b스레드가 알 수 없다.
        // 가변 데이터는 단일 스레드에서만 사용하는걸로 하자

        //1. immutable
        //2. 무조건적 스레드 안전
        //3. 조건부 스레드 안전
        //4. 스레드 안전하지 않음
        //5. 스레드 적대적

        Thread backgroundThread = new Thread(()-> {
           int i = 0;
           if(!stopRequested) {
               i++;
               System.out.println("1 sleep");
           }
        });

        Thread backgroundThread2 = new Thread(()-> {
            int i = 0;
            if(!stopRequested) {
                i++;
                System.out.println("2 sleep");
            }
        });

        backgroundThread.start();
        backgroundThread2.start();



        TimeUnit.SECONDS.sleep(5);
        stopRequested = true;

    }
}
