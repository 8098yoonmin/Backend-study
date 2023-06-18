public abstract class Pay {


    public void payment(int price, int amount) {
        connect();
        process(price, amount);
        after();
    };

    protected void connect() {} ;
    


    protected void process(int price, int amount){};

    public void after() {
        System.out.println("결제 종료");
    }
}


class Credit extends Pay {
    public void connect() {
        System.out.println("신용카드사에 연결중입니다..");
    }

    public void process(int price, int amount) {
        System.out.println(price + "원 결제를 진행중입니다..");
    }

}

class OnlinePay extends Pay {
    public void connect() {
        System.out.println("온라인 페이사에 연결중입니다..");
    }

    public void process(int price, int amount) {
        System.out.println(price+ "원 결제를 진행중입니다..");
    }

}

class Cash extends Pay {
    
    public void process(int price, int amount) {
        int[] money = {500, 100};
        int left = amount - price ;
        int count = 0; 

        if( amount < price) {
            System.out.println("금액이 부족합니다.");
        }
        else {
            for(int i=0; i<money.length; i++) {
                int num = (left / money[i]);
                count += num;
                left = left - (num * money[i]); 
            } 
            System.out.println("거스름돈: " + (amount - price) +"원");
            System.out.println("거스름돈 동전 갯수: " + count);


        }
    }
}

