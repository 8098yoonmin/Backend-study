package org.nhnacademy.tip.ex5;

public class TestCounterAgent {
    public static void main(String[] args) {
        Counter counter = new Counter();
        int numberofIterations = 1000000;
        CountAgent countAgent1  = new CountAgent(counter, numberofIterations, true);
        CountAgent countAgent2  = new CountAgent(counter, numberofIterations, false);

        long startTime = System.currentTimeMillis();
        countAgent1.start();
        countAgent2.start();

        try{
            countAgent1.join();
            countAgent2.join();
        } catch(InterruptedException ignore) {

        }
        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Count: " + counter.getCount() +", AnotherCount: " + counter.getAnotherCount());
        System.out.println("Time: " + elapsedTime);


    }
}
