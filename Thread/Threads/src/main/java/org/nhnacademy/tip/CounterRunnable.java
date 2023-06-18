package org.nhnacademy.tip;

public class CounterRunnable implements Runnable {
    int count;
    String name;

    public CounterRunnable(String name) {
        this.name = name;
        count = 0;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()) {
            try {
                ++count;
                System.out.println(this.name +": " + count);

                Thread.sleep(1000);
            } catch(InterruptedException ignore) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
