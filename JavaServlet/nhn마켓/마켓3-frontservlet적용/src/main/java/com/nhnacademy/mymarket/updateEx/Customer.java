package com.nhnacademy.mymarket.updateEx;

public class Customer {
    // 고객의 구매 목록
    private final BuyList buyList;
    // 고객의 장바구니
    private Basket basket;

    //고객의 주머니 사정
    private int money = 20000;

    public Customer(BuyList buyList) {
        this.buyList = buyList;
    }

    // 장바구니를 챙김
    public void bring(Basket basket) {
        this.basket = basket;
    }

    //식품을 담음
    public void pickFoods(FoodStand foodStand) {
        //buylist에서 목록 뽑아서 foodStand(안의 food arraylist)에 있으면 basket에 담기 
        for(int i = 0; i< buyList.size(); i++) {
            try{
                Food food = foodStand.getFood(buyList.getItem(i).getName());
                basket.add(food);
                foodStand.sub(food);
            } catch(Exception e) {
                System.out.println("재고가 부족합니다!");
                basket.makeEmpty();
            }
        }
       
        
    }

    //계산하기
    public void payTox(Counter counter) {
        counter.calFoods(basket);
        counter.change(money);
    }

}
