package Builder_디자인패턴아님;

public class Guitarist {
    private final int guitaristNo;
    private final String name;
    private final String guitarType;
    private final String guitarMaker;
    private final String playingType;
    private final String genre;
    private final String teamName;

    //builder가 각각의 값을 할당함.
    private Guitarist(Builder builder) {
        this.guitarType = builder.guitarType();
        this.guitarMaker = builder.guitarType();
    }

    // public Guitarist(int guitaristNo) {
    //     this.guitaristNo = guitaristNo;
    // }
    // public Guitarist(int guitaristNo, String name) {
    //     this.guitaristNo = guitaristNo;
    //     this.name = name;
    // }
    // public Guitarist(int guitaristNo, String name, String guitarType) {
    //     this.guitaristNo = guitaristNo;
    //     this.name = name;
    //     this.guitarType = guitarType;
    // }


    //객체의 생성을 담당하는 클래스를 따로 생성 > 값의 생성을 builder에게 위임(빌더 패턴은 아님)
    public static class Builder {
        private int guitaristNo;
        private String name;
        private String guitarType;
        private String guitarMaker;
        private String playingType;
        private String genre;
        private String teamName;

        public Builder(int guitaristNo, String name) {
            this.guitaristNo = guitaristNo;
            this.name = name;
        }

        private Builder guitarType(String value) {
            this.guitarType = value;
            return this; //체인생성
        }
        private Builder guitarMaker(String value) {
            this.guitarMaker = value;
            return this;
        }

        public Guitarist build() {
            return new Guitarist(this);
        }
    }
}

class Test {
    public static void main(String[] args) {
        Guitarist guitarist = Guitarist.Builder(new Guitarist.Builder()
        .guitarType("les paul")
        .guitarMaker("gibson")
        .build());
    }
}