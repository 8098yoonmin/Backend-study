package framework;

//일부 구현을 포함하고, 상속에 구현을 강제하는 메소드를 포함한 클래스 

public abstract class Factory {
    public final Product createProduct(int modelNumber, String modelName) {
        Product product = create(modelNumber, modelName);
        return product;
    }

    protected abstract Product create(int modelNumber, String modelName);
    protected abstract void setCategory(Product product);
}
