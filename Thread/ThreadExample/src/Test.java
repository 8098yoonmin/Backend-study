public class Test {
   public static void main(String[] args) {
    AThread task1 = new AThread();
    Thread task2 = new Thread(new BThread());

    task1.start();
    task2.start();
} 
}

class AThread extends Thread {
    @Override
    public void run() {
        while(true)
            try{
                System.out.println("ATread");
                Thread.sleep(500);
            }
            catch(InterruptedException e) {

            }
    }
}

class BThread implements Runnable {
    @Override
    public void run() {
        while(true)
            try{
                System.out.println("BThread");
                Thread.sleep(500);
            }
            catch(InterruptedException e) {
            }
    }
}
