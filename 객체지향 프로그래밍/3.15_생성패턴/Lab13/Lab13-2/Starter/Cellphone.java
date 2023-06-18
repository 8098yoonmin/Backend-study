package product;
import framework.*;

public class Cellphone implements Product {
    int modelNumber;
    String modelName;
    String category;

    public Cellphone(int modelNumber, String modelName) {
        this.modelNumber = modelNumber;
        this.modelName = modelName;
    }

    public int getModelNumber() {
        return this.modelNumber;
    }

    public String getProductName() {
        return this.modelName;
    }

    public String getCategoryName() {
        return this.category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    
}
