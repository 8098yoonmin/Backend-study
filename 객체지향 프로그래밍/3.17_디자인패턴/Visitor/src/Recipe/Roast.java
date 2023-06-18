package Recipe;

import Ingredient.Acceptor;

public class Roast implements Visitor {

    @Override
    public void visit(Acceptor acceptor) {
        System.out.println("Preparing...");
        System.out.println("팬에 열을 가합니다.");
        System.out.println(acceptor.getName()+" "+acceptor.getQuantity()+acceptor.getUnit()+"을 굽습니다.");
        System.out.println("건져냅니다.");
      }
    
}
