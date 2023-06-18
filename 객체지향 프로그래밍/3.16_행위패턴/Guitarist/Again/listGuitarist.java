package Guitarist.Again;

import java.util.ArrayList;
import java.util.Iterator;


//E 대신 Guitarist가 되도록..

public class listGuitarist<E> extends ArrayList<E> {
    public Iterator<E> iterator() {
        listGuitarist<E> list = this;
        return new Iterator<>(){
            private int pointer = -1;

            public boolean hasNext() {
                if( pointer < (list.size()-1)) return true;
                return false;
            }
            
            public E next() {
                pointer++;
                E it;
                try {
                    it = list.get(pointer);
                } catch(IndexOutOfBoundsException e) {
                    System.err.println("배열의 범위를 벗어남");
                }
                return it;
            }

            public void remove() {
                if( -1 < pointer && pointer < list.size()) {
                    list.remove(pointer);
                    pointer--;
                    return;
                }
                throw new IllegalStateException();
            }
        };
    }
}
