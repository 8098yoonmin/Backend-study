public abstract class Framework {
    int no;
    String name;

    public Framework(int no, String name) {
        this.no = no;
        this.name = name;
    }

    //이 부분이 템플릿 메소드 패턴(상위에서 하위 호출은 가능, 하위에서 상위호출은 불가능한 기본 원칙은 잘 지켜짐)
    public void cook() {
        boil();
        insertNoodle();
        insertsoup();
    }

    public void boil() {
        System.out.println("물을 끓입니다");
    }

    public void insertNoodle() {
        System.out.println("라면을 넣습니다");
    }

    public void insertsoup();
}

class Nuguri extends Framework {
    public Nuguri(int no, String name) {
        super(no, name);
    }

    public void insertsoup() {
        System.out.println("다시마 넣습니다");
        System.out.println("스프를 넣습니다");
    }
}


class Sin extends Framework {
    public Sin(int no, String name) {
        super(no, name);
    }

    public void insertsoup() {

        System.out.println("스프를 넣습니다");
    }
}

class Main {
    public static void main(String[] name) {
        Framework f = new Nuguri(1, null);
        f.cook();
    }
}