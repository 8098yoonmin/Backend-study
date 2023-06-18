package Recipe;

import Ingredient.Acceptor;

public class Boil implements Visitor {

    @Override
    public void visit(Acceptor acceptor) {
        System.out.println("Preparing..");
        System.out.println("물을 끓입니다.");
        System.out.println(acceptor.getName()+" " + acceptor.getQuantity()+ acceptor.getUnit() +"을 물에 넣습니다.");
        System.out.println("건져냅니다.");
      }
    
}
