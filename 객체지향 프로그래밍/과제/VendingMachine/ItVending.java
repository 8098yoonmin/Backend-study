public class ItVending extends VendingMachine {
    
    public Drink createDrink(String name) {
        Drink drink = null; 
        if(name.equals("아메리카노")) {
            drink = new Americano();
        }
        else if(name.equals("카페라떼")) {
            drink = new Latte();
        }
        else if(name.equals("모카치노")) {
            drink = new Mocha();
        }
        else if(name.equals("핫초코")) {
            drink = new HotChoco();
        }
        else if(name.equals("아이스아메리카노")) {
            drink =new IceAmericano();
        }
        else if(name.equals("아이스초코")) {
            drink = new IceChoco();
        }
        else if(name.equals("아이스카페라떼")) {
            drink = new IceLatte();
        }
        else if(name.equals("복숭아아이스티")) {
            drink = new IceTea();
        }
        else {
            System.out.println("Error: 올바르지 않은 메뉴입니다.");
        }

        return drink;
    }

    public Pay createPay(String payMethod) {
        Pay pay = null;
        if(payMethod.equals("현금")) {
            pay = new Cash();
        }
        else if(payMethod.equals("신용카드")) {
            pay = new Credit();
        }
        else if(payMethod.equals("온라인결제")) {
            pay = new OnlinePay();
        }
        else{
            System.out.println("Error: 올바르지 않은 결제 방식입니다.");
        }
        return pay;
    }


}
