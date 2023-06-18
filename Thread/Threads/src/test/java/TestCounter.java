import org.nhnacademy.tip.Counter;

public class TestCounter {
    public static void main(String[] args) {
        Counter counter1 = new Counter("Counter1");
        Counter counter2 = new Counter("Counter2");

        counter1.run();
        counter2.run();
    }
}
