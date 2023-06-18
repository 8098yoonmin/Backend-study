import java.util.Iterator;

public class DrummerEnumerableAdapter implements Iterable<Drummer> {
    DrummerList enumerable;

    public DrummerEnumerableAdapter(DrummerList enumerable){
        this.enumerable = enumerable;
    }


    @Override
    public Iterator<Drummer> iterator() {
        return new DrummerEnumeratorAdapter(enumerable.enumerator());
    }
}
