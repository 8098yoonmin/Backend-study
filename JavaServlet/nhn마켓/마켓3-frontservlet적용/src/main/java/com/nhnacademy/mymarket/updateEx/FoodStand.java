package com.nhnacademy.mymarket.updateEx;

import java.util.ArrayList;
import java.util.Iterator;

public class FoodStand {
    // private final
    private final ArrayList<Food> foods = new ArrayList<>();
    Iterator<Food> iter;
    public Food target = new Food();

    public void add(Food onion1) {
        foods.add(onion1);
    }
    
    public ArrayList getList() {
        return this.foods;
    }

    public int size() {
        return foods.size();
    }

    public Food get(int i) {
        return foods.get(i);
    }

    public Food getFood(String name) {
        for(Food food: foods) {
            if(food.getName().equals(name)){
            target = food;
            break;
            }    
        }
        return target ;
    }

    public boolean sub(Food food) throws Exception {
        iter = foods.iterator();

        while(iter.hasNext()) {
            if(iter.next().getName() == food.getName()) {
                iter.remove();
                return true;
            }
        }
        throw new Exception("재고가 없습니다.");
    }
}
