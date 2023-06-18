import framework.*;
import factory.*;

class Test {
    public static void main(String[] args) {
        Product cellphone = new CellphoneFactory().create(111,"Cellphone");
        cellphone.setCategory("Mobile Device");
        
    }
}
