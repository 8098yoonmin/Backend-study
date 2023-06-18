package Recipe;

import Ingredient.Acceptor;

public class Fry implements Visitor{
    public void visit(Acceptor acceptor) {
        System.out.println("Starting art...");
        System.out.println("기름을 끓입니다");
        System.out.println(acceptor.getName() + " "+ acceptor.getQuantity()  + acceptor.getUnit()+"을 기름에 넣습니다.");
        System.out.println("건져냅니다");

    }


}
