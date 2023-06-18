package Ingredient;

import Recipe.Visitor;
//재료 역할
public abstract class Acceptor {
    //이름
    protected String name;
    //양
    protected int quantity;
    //단위
    protected String unit;

    public Acceptor(String name, int quantity, String unit) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getUnit() {
        return this.unit;
    }

    public void accept(Visitor visitor) { }
}