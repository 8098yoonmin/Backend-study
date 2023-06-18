public class Singleton {

    private static Singleton singleton; 
    private int number;

    private Singleton() {}

    public static Singleton getSingleton() {
        if(singleton == null) {
            singleton = new Singleton();
            return singleton;
        }
        return singleton;
    }

    public int getNumber() {
        return this.number++;
    }
}