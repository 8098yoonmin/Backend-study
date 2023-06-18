package org.nhnacademy.tip.ex5;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class TestHoldAndWaitDeadlock {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        Thread task1 = new Thread(()-> {
            while(!Thread.interrupted()) {
                try {
                    System.out.println("Task1: lock");
                    lock.lock();
                    Thread.sleep(1000);
                    lock.unlock();
                    System.out.println("Task1: unlock");
                } catch(InterruptedException ignore){
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread task2 = new Thread(()-> {
            while(!Thread.interrupted()) {
                try {
                    System.out.println("Task2: lock");
                    lock.lock();
                    Thread.sleep(10000);
                    lock.unlock();
                    System.out.println("Task2: interrupt unlock");
                } catch(InterruptedException ignore){
                    System.out.println("Task2 : interrupt");
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
            }
            System.out.println(("Task2: finished"));
        });

        task1.setName("Task1");
        task2.setName("Task2");
        task1.start();
        task2.start();

        try {
            Thread.sleep(2000);
        } catch(InterruptedException ignore) {

        }

        System.out.println("테스트 종료");
    }
}
