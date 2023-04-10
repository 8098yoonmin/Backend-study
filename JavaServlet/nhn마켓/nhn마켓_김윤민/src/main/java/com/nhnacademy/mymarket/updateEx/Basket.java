package com.nhnacademy.mymarket.updateEx;

import java.util.ArrayList;

public class Basket {
    private final ArrayList<Food> foods = new ArrayList<>();
    //private final
    public void add(Food food) {
        foods.add(food);
    }

    public ArrayList getList() {
        return this.foods;
    }

    public Food get(int i) {
        return foods.get(i);
    }

    public void makeEmpty() {
        foods.clear();
    }

    // public Food getFood(int i) {
    //     return foods.get(i);
    // }
}
