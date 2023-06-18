
public abstract class HotDrink implements Drink {
    String name;
    int price;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    //Templete method
    public void make() {
        cup();
        syrup();
        material();
        total();
    }

    public void cup() {
        System.out.println("종이컵을 받습니다.");
    }

    public void syrup() {};

    public void material() {};

    public void total() {};

}

class Americano extends HotDrink {
    public Americano() {
        name = "아메리카노 만드는 중";
        price = 1500;
    }

    public void material() {
        System.out.println("원두를 추출합니다.");
        System.out.println("물을 넣습니다.");
    }

    public void total() {
        System.out.println("아메리카노가 완성됐습니다.");
    }
}

class Latte extends HotDrink {
    public Latte() {
        name = "카페라떼 만드는 중..";
        price = 2000;
    }

    public void material() {
        System.out.println("원두를 추출합니다.");
        System.out.println("우유를 넣습니다.");
    }

    public void total() {
        System.out.println("카페라떼가 완성됐습니다.");
    }
}

class Mocha extends HotDrink {
    public Mocha() {
        name = "모카치노 만드는 중..";
        price = 4000;
    }

    public void syrup() {
        System.out.println("초코시럽을 넣습니다.");
    }
    
    public void material() {
        System.out.println("원두를 추출합니다.");
        System.out.println("우유를 넣습니다.");
    }

    public void total() {
        System.out.println("모카치노가 완성됐습니다.");
    }
}

class HotChoco extends HotDrink {
    public HotChoco() {
        name = "핫초코 만드는중..";
        price = 3500;
    }

    public void syrup() {
        System.out.println("초코시럽을 넣습니다.");
    }

    public void material() {
        System.out.println("우유를 넣습니다.");
    }

    public void total() {
        System.out.println("핫초코가 완성됐습니다.");
    }
}