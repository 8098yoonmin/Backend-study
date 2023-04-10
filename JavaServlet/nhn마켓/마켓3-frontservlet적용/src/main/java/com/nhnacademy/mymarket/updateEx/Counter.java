package com.nhnacademy.mymarket.updateEx;

import java.util.ArrayList;
import java.util.List;

public class Counter {
    private int sum = 0;
    private ArrayList<Food> foods = new ArrayList<>();


    // 장바구니 금액산정
    public int calFoods (Basket basket) {
        foods = basket.getList();
        for(Food food : foods) {
            sum += food.getPrice();
        }
        System.out.println("총 가격은 "+sum+"원 입니다.");
        return sum;
    }

    // 거스름돈 거슬러주기 
    public void change(int money) {
        int rest = money - sum;
        if( rest < 0) {
            System.out.println("잔액이 부족합니다.");
        } else {
        System.out.println("고객님 결제 후 잔액: " + rest);
        }
    }
}

