package com.nhnacademy.mymarket.utils;

import com.nhnacademy.mymarket.updateEx.Food;
import com.nhnacademy.mymarket.updateEx.FoodStand;

import javax.servlet.ServletContext;

public final class MartUtils {
    private MartUtils() {
        throw new IllegalStateException("Utility class");
    }

    static int onionPrice;
    static int eggPrice;
    public static void stackFood(ServletContext servletContext) {
        FoodStand foodStand = new FoodStand();

        for(int i=0; i<2; i++) {
            onionPrice = Integer.parseInt(servletContext.getInitParameter("onion"));
            foodStand.add(new Food("onion", onionPrice));
        }

        for(int i=0; i<5; i++) {
            eggPrice = Integer.parseInt(servletContext.getInitParameter("egg"));
            foodStand.add(new Food("egg", eggPrice));
        }
        servletContext.setAttribute("foodStand", foodStand);
    }

}
