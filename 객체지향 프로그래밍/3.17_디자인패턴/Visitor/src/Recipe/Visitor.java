package Recipe;
import Ingredient.Acceptor;

public interface Visitor {
    void visit(Acceptor acceptor);
}
