package org.nhnacademy.tip;

import java.util.concurrent.ThreadLocalRandom;

public class Receiver implements Runnable {
    Thread thread;
    Pipe pipe;

    public Receiver(Pipe pipe) {
        this.pipe = pipe;
        thread = new Thread(this);

    }

    public void start() {
        thread.start();

    }
    public void stop() {
        thread.interrupt();
        try {
            thread.join();
        } catch(InterruptedException ignore) {

        }
    }
    public Thread.State getState() {
        return thread.getState();
    }
    @Override
    public void run() {
        while(!Thread.interrupted()) {
            try {
                System.out.println("Received data: " + pipe.data);
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000,5000));

            } catch(InterruptedException ignore) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
