package org.nhnacademy.tip;

public class CounterThread extends Thread {
    String name;
    int count;

    public CounterThread(String name) {
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
                interrupt();
            }
        }
    }
}
