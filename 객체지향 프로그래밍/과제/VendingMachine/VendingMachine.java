public abstract class VendingMachine {

    protected abstract Drink createDrink(String drinkName);
    protected abstract Pay createPay(String drinkName);

    public void makeDrink(String drinkName, String payMethod, int amount) {
        Drink drink = createDrink(drinkName);
        Pay payDrink = createPay(payMethod);
        payDrink.payment(drink.getPrice(), amount);

        if(drink.getPrice() > amount) {
            System.out.println("결제 실패.");
        }
        else {        
            System.out.println(drink.getName()); 
            drink.make();
        }
    }

}
