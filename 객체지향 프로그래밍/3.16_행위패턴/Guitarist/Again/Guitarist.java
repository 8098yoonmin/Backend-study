package Guitarist.Again;

public class Guitarist {
  private int guitaristNo;
  private String name;
  private String genre;    


  public static class Builder {
    private final String name;
    private final int guitaristNo;
    private String genre = "";

    public Builder(String name, int guitaristNo) {
        this.name = name;
        this.guitaristNo = guitaristNo;
    }

    public Builder genre(String val) {
        genre = val;
        return this;
    }

    public Guitarist build() {
        return new Guitarist(this);
    }
  }
}
