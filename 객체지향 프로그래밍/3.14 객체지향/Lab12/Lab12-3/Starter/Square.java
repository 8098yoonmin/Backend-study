public class Square implements Shape {
    //정사각형 만들기
    
    int length;

    public Square(int length) {
        this.length = length;
    }

    @Override
    public Number getArea() {
        return this.length * 2;
    }
    

}
