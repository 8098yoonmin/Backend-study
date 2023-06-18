import javax.xml.stream.FactoryConfigurationError;

import Ingredient.Pork;
import Recipe.Boil;
import Recipe.Fry;
import Recipe.Roast;

public class App {
    public static void main(String[] args) throws Exception {
        Pork pork = new Pork("돼지고기", 200, "g");
        Fry fry = new Fry();
        Boil boil = new Boil();
        Roast roasting = new Roast();

        //fry.visit(pork);
        //boil.visit(pork);
        //roasting.visit(pork);

        pork.accept(fry);
        pork.accept(roasting);
        pork.accept(boil);
    }
}
