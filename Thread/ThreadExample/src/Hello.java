public class Hello {
   public static void main(String[] args) {
    System.out.println("Hello, World!");
    Thread thread = Thread.currentThread();
    System.out.println(thread.getName());
    System.out.print(thread.getPriority());
    
   } 
}
