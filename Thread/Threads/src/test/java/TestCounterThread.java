import org.nhnacademy.tip.CounterThread;

public class TestCounterThread {

    public static void main(String[] args) {
        CounterThread counter1 = new CounterThread("Counter1");
        CounterThread counter2 = new CounterThread("Counter2");

        //Thread는 run이 아닌 start사용
        counter1.start();
        counter2.start();
    }
}
