//불변 객체를 만들어낼 때 많이 쓰는 구조 

public class Drummer {

    private final int drummerNo;
    private final String name;
    
    private final int numberOfBass;
    private final int countOfSymbol;
    private final String teamName;

    private Drummer(Builder builder) {
        this.drummerNo = builder.drummerNo;
        this.name = builder.name;
        this.numberOfBass = builder.numberOfBass;
        this.countOfSymbol = builder.countOfSymbol;
        this.teamName = builder.teamName;
    }

    @Override
    public String toString() {
        return this.name +" " + this.teamName;
    }
    
    public static class Builder {
        private int drummerNo;
        private String name;
        
        private int numberOfBass;
        private int countOfSymbol;
        private String teamName;

        public Builder(int drummerNo, String name) {
            this.drummerNo = drummerNo;
            this.name = name;
        }

        public Builder numberOfBass(int value) {
            this.numberOfBass = value;
            return this; //builder의 객체가 튀어나옴 
        }

        public Builder countOfSymbol(int value) {
            this.countOfSymbol = value;
            return this;
            //this를 반환하면 chain형태 구현이 가능함 
        }

        public Builder teamName(String teamName) {
            this.teamName = teamName;
            return this;
        }

        public Drummer build() {
            return new Drummer(this);
        }
    }
}


