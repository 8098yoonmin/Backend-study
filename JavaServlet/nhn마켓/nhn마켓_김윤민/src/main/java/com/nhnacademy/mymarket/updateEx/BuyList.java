package com.nhnacademy.mymarket.updateEx;

import java.util.ArrayList;

public class BuyList {
    private final ArrayList<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public int size() {
       return items.size();
    }

    public Item getItem(int i) {
        return items.get(i);
    }

    

    public static class Item {
        private final String name;

        //private final int amount;
        public Item(String name) {
            this.name = name;
            //this.amount = amount;
        }

        public String getName() {
            return this.name;
        }

        @Override
        public String toString() {
        return "Food{" +
                "name='" + name + '\'' +'}';
                //", amount=" + amount +
                //'}';
    }
    }
}
