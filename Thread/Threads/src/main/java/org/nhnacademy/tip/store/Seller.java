package org.nhnacademy.tip.store;
import java.util.concurrent.ThreadLocalRandom;

public class Seller extends Thread {
    Store store;

    public Seller(Store store) {
        this.store = store;
    }

    //비워지지 않도록 채워둔다.
    @Override
    public void run() {
        while(!Thread.interrupted()){
            if(store.boxCount < 10) {
                try {
                    store.sell();
                    Thread.sleep(ThreadLocalRandom.current().nextLong(100,200));
                } catch (InterruptedException ignore) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}