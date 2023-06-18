public class Triangle implements Shape {
    int height;
    int width;

    public Triangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public Number getArea() {
        return this.height * this.width / 2 ;
    }
    
}
