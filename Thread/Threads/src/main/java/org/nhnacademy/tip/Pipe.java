package org.nhnacademy.tip;

public class Pipe {
    int data;
    boolean empty;

    public Pipe() {
        data =0;
        empty = true;
    }

    public synchronized int receive() throws InterruptedException {
        while (empty) {
            try {
                //System.out.println("waiting for receive");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw e;
            }
            }
            empty = true;
            notify();
            return data;
        }



        public synchronized void send(int data) throws InterruptedException {
            while (!empty) {
                try {
                    //System.out.println("waiting for send");
                    wait();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            this.data = data;
            this.empty = false;
            notify(); //알리는 것
          //  System.out.println("Sent");
        }


    }
