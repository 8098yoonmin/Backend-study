package Guitarist.Again;

import java.util.Iterator;

public class Test {

    public void printEnumerable(Enumerable enumerable) {
        while(enumerable.enumerator().hasMoreElements()) {
            System.out.println(enumerable.enumerator().current());
        }
    }
    public static void main(String[] args) {
        listGuitarist<String> list = new listGuitarist<String>();
        list.add("기타1");
        list.add("기타2");
        list.add("기타3");

        list.add(new Guitarlist.Builder(1,"Randy Rhoads").guitar("Les Pual")));

        Iterator<String> it = list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
            it.remove();
        }

        System.out.println( it.hasNext());

    }
}
