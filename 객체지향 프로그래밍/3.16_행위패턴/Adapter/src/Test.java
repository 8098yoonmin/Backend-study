public class Test {
    // Builder b = new Builder();
    // b.numberOfBass().countOfSymbol().teamName()

    public static void printList(Enumerable list) {
        Enumerator e = list.enumerator();
        while(e.hasMoreElement()) {
            System.out.println(e.current()); 
        }
    }
    
    public static void main(String[] args) {
    DrummerList list = new DrummerList(3);

    list.add(new Drummer.Builder(1, "John Bonnhm")
        .numberOfBass(1)
        .countOfSymbol(6)
        .teamName("Led Zeppelin")
        .build());

    list.add(new Drummer.Builder(2, "Yoom")
    .numberOfBass(2)
    .countOfSymbol(3)
    .teamName("Metal")
    .build());

    list.add(new Drummer.Builder(3, "Karl")
    .numberOfBass(4)
    .countOfSymbol(5)
    .teamName("Blp")
    .build());
    
    //printList(list);
    
    Iterable<Drummer> iterable = new DrummerEnumerableAdapter(list);
    for(Drummer dmr : iterable) {
        System.out.println(dmr);
    }
    

    }   


}
