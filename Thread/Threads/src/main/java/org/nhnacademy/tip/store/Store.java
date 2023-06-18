package org.nhnacademy.tip.store;

import java.util.concurrent.Semaphore;

public class Store {
    Semaphore tickets;
    int boxCount;

    public Store(String s) {
        boxCount =0;
        tickets = new Semaphore(5);
    }

    public void enter() throws InterruptedException {
        try {
            tickets.acquire();
            System.out.println(Thread.currentThread().getName() +"입장");
        } catch(InterruptedException e) {
            throw e;
        }

    }

    public void exit() {
        System.out.println(Thread.currentThread().getName() +"퇴장");
        tickets.release();
    }

    public synchronized void buy() {
        while(boxCount == 0) {
            try {
                System.out.println(Thread.currentThread().getName() + "구매 대기");
                wait(); //1개도 없을 땐 기다림
                Thread.sleep(100);
            } catch(InterruptedException ignore) {

            }

        }

        --boxCount;
        System.out.println("구매 완료, 재고: " + boxCount);

        notify();
    }

    public synchronized void sell() {
        while(boxCount >= 10) {
            try {
                System.out.println("납품 대기 중입니다.");
                wait(); //납품 대기
                Thread.sleep(100);
            } catch(InterruptedException ignore) {

            }

        }

        ++boxCount;
        System.out.println("납품 완료. 재고 : " + boxCount);

        notifyAll();
    }

}
