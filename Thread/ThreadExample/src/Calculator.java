public class Calculator {
    private int memory;

    public int getMemory() {
        return this.memory;
    }

    //synchronized는 상호배제를 구현한다는 뜻
    public synchronized void setMemory(int value) {
        //synchronized { 상호배제를 구현하는 또다른 방법
        try{
            Thread.sleep(2000);
            this.memory = value;
            System.out.println(Thread.currentThread().getName()+": "+ this.memory);   
        }
        catch(Exception e) { }
        //}
    }

}

class User extends Thread {
    private Calculator calculator;
    int memory;

    public User(String name, int memory) {
        this.setName(name);
        this.memory = memory;
    } 

    public void setCalculator(Calculator calculator) {
            this.calculator = calculator;
        
    }

    @Override
    public void run() {
        calculator.setMemory(this.memory);
      
    }
}

class Test{
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        User user1 = new User("User1", 100);
        User user2 = new User("User2", 50);

        user1.setCalculator(calculator);
        user1.start();
        
        user2.setCalculator(calculator);
        user2.start();
    }
}
