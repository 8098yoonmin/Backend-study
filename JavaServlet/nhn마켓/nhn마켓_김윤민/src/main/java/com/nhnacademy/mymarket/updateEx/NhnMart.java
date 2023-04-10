package com.nhnacademy.mymarket.updateEx;

import java.util.Scanner;

class NhnMartShell {
    public static void main(String[] args) {
        NhnMart mart = new NhnMart();
        mart.prepareMart();

        BuyList buyList = inputBuyListFromShell();
        

        Customer jordan = new Customer(buyList);
        // 장바구니를 챙긴다.
        jordan.bring(mart.provideBasket());

        // 식품을 담는다.
        jordan.pickFoods(mart.getFoodStand());
        
        // 카운터에서 계산한다.
        jordan.payTox(mart.getCounter());
    }

    //구매목록 작성 
    private static BuyList inputBuyListFromShell() {
        BuyList buyList = new BuyList();
        Scanner sc = new Scanner(System.in);
        while(true) {
            String item = sc.nextLine();
            if(item.equals("끝")) {
                break;
            }
            else {
                String basket[] = item.split(" ");
                int num = Integer.parseInt(basket[1]);
                for(int i=0; i<num; i++) {
                    buyList.add(new BuyList.Item(basket[0]));
                }
            }
        }
        sc.close();

        // Scanner에서 buyList 만들기
        //        BuyList buyList = new BuyList();
//        buyList.add(new BuyList.Item("양파", 2));
//        buyList.add(new BuyList.Item("계란", 3));
        // TODO
        return buyList;
    }
}

public class NhnMart {
    private final FoodStand foodStand = new FoodStand();
    private final Counter counter = new Counter();

    public void prepareMart() {
        fillFoodStand();
    }

    private void fillFoodStand() {
        for (int i = 0; i < 2; i++) {
            foodStand.add(new Food("양파", 1000));
        }
        for (int i = 0; i < 5; i++) {
            foodStand.add(new Food("계란(30개)", 5000));
        }
        for (int i = 0; i < 10; i++) {
            foodStand.add(new Food("파", 500));
        }
        for (int i = 0; i < 20; i++) {
            foodStand.add(new Food("사과", 2000));
        }
    }

    public Basket provideBasket() {
        return new Basket();
    }

    public FoodStand getFoodStand() {
        return this.foodStand;
    }

    
    public Counter getCounter() {
        return this.counter;
    }
}
