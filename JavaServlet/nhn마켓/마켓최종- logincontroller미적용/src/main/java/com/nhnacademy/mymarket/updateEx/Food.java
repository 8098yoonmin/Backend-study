package com.nhnacademy.mymarket.updateEx;

public class Food {
    private final String name;
    private final int price;

    public Food() {
        this.name="";
        this.price=0;
    }

    public Food(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
