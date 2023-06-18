import org.nhnacademy.tip.Counter;
import org.nhnacademy.tip.CounterRunnable;

public class TestCounterRunnable {

    public static void main(String[] args) {
        Counter counter1 = new Counter("Counter1");
        CounterRunnable counterRunnable = new CounterRunnable("CounterRunnable");
        Thread counter2 = new Thread(counterRunnable);

        counter2.start();
        counter1.run();
    }
}
