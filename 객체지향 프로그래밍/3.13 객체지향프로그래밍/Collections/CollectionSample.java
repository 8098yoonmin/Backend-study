import java.util.*;

public class CollectionSample {
   List<String> list = new LinkedList<>();

   public void add(String value) {
    this.list.add(value);
   }

   public void remove(String value) {
    this.list.remove(value);
   }

public static void main(String[] args) {
    
    List<String> list = new ArrayList<>();
    // list가 iterable의 서브타입이 됨
    list.add("Hello");
    list.add("World");

    
    for(String value: list) {
        System.out.println(value);
    }
}

}