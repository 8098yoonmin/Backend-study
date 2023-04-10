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
        int eggAmount=0;
        int onionAmount=0;

        for(int i=0; i<2; i++) {
            onionPrice = Integer.parseInt(servletContext.getInitParameter("onion"));
            foodStand.add(new Food("onion", onionPrice));
            onionAmount++;
        }

        for(int i=0; i<5; i++) {
            eggPrice = Integer.parseInt(servletContext.getInitParameter("egg"));
            foodStand.add(new Food("egg", eggPrice));
            eggAmount++;
        }
        servletContext.setAttribute("foodStand", foodStand);
        servletContext.setAttribute("eggAmount", eggAmount);
        servletContext.setAttribute("onionAmount", onionAmount);
    }

}
