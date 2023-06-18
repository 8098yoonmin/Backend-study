package factory;
import framework.*;
import product.*;


public class CellphoneFactory extends Factory {
    protected Product create(String string, String modelName) {
        Product product = new Cellphone(stringelName);
        return product;
    }

    protected void setCategory(Product product) {
        product.setCategory("Mobile Device");
    }
}
