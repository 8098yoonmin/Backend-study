public class Test {
    public static void main(String[] args) {
        AreaCalculator calc = new AreaCalculator();

        Number n = calc.sumOfShapes(new Rectangle(10,10), new Square(10));
        Number m  = calc.sumOfShapes(new Triangle(10,10), new Square(10));

        
    }
}