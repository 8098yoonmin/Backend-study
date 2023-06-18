public abstract class IcedDrink implements Drink {
    String name;
    int price;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
    //Templete method.
    public void make() {
        cup();
        ice();
        syrup();
        material();
        total();
    }

    public void cup() {
        System.out.println("플라스틱 컵을 받습니다.");
    }

    public void ice() {
        System.out.println("얼음을 받습니다.");
    }

    protected void syrup() {};

    protected void material() {};

    protected void total() {};
}

class IceAmericano extends IcedDrink {
    
    public IceAmericano() {
        name = "아이스 아메리카노 만드는 중..";
        price = 2000;
    }

    public void material() {
        System.out.println("원두를 추출합니다.");
        System.out.println("물을 넣습니다.");
    }

    public void total() {
        System.out.println("아이스 아메리카노가 완성됐습니다.");
    }
}

class IceChoco extends IcedDrink {
    
    public IceChoco(){
        name = "아이스 초코 만드는 중..";
        price = 4000;
    }

    public void syrup() {
        System.out.println("초코 시럽을 추가합니다.");
    }

    public void material() {
        System.out.println("우유를 넣습니다.");
    }

    public void total() {
        System.out.println("아이스 초코가 완성됐습니다.");
    }
}

class IceLatte extends IcedDrink {
    
    public IceLatte() {
        name = "아이스 카페라떼 만드는 중..";
        price = 2500;
    }

    public void material() {
        System.out.println("원두를 추출합니다.");
        System.out.println("우유를 넣습니다.");
    }

    public void total() {
        System.out.println("아이스 카페라떼가 완성됐습니다.");
    }
}

class IceTea extends IcedDrink {
    public IceTea() {
        name = "복숭아 아이스티 만드는 중..";
        price = 3500;
    }

    public void syrup() {
        System.out.println("아이스티 가루를 넣습니다.");
    }

    public void material() {
        System.out.println("물을 넣습니다.");
    }

    public void total() {
        System.out.println("복숭아 아이스티가 완성됐습니다.");
    }
}