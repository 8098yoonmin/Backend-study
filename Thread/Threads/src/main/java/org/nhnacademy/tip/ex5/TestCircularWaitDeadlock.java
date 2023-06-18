package org.nhnacademy.tip.ex5;

public class TestCircularWaitDeadlock {
    public static void main(String[] args) {
        Object resource1 = new Object();
        Object resource2 = new Object();


        //runnable은 람다 표현으로 사용가능
        Thread task1 = new Thread(()-> {
			while(!Thread.interrupted()) {
                synchronized (resource1) {
                    System.out.println("Task1 resource1 획득");

                    synchronized (resource2) {
                        System.out.println("Task1 resource2 획득");

                        System.out.println(resource1+"-" + resource2);
                    }
                }
            }
        });

        Thread task2 = new Thread(()-> {
            while(!Thread.interrupted()) {
                synchronized (resource2) {
                    System.out.println("Task2 resource1 획득");

                    synchronized (resource1) {
                        System.out.println("Task2 resource2 획득");

                        System.out.println(resource1+"-" + resource2);
                    }
                }
            }
        });

        task1.start();
        task2.start();
    }
}