import java.util.Iterator;

public class DrummerEnumeratorAdapter implements Iterator<Drummer> {
    Enumerator enumerator;

    //DrummerEnumerator??
    public DrummerEnumeratorAdapter(Enumerator enumerator) {
        this.enumerator = enumerator;
    }

    @Override
    public boolean hasNext() {
        return enumerator.hasMoreElement();
    }

    @Override
    public Drummer next() {
        return (Drummer)enumerator.current();
    }

}