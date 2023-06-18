public class TestSingleton {
    public static void main(String[] args) {
        Singleton single = Singleton.getSingleton();
        System.out.println(single.getNumber());
        System.out.println(single.getNumber());
        System.out.println(single.getNumber());
        Singleton single2 = Singleton.getSingleton();
        System.out.println(single2.getNumber());


    }
}
