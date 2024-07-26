package CreationDesignPattern.ProtoTypeDP;

import java.util.List;

public class ProtoTypeMain {
    public static void main(){
        PizzaFlavour hawaiian = new PizzaFlavour("Hawaiian");
        Pizza hawaiianPizza1 = new Pizza(4, hawaiian);
        Pizza hawaiianPizza2 = hawaiianPizza1.clone();
        Pizza hawaiianPizza3 = hawaiianPizza1.clone();
        Pizza hawaiianPizza4 = hawaiianPizza1.clone();
        Pizza hawaiianPizza5 =hawaiianPizza1.clone();
        hawaiian.setName("Hawaii with extra cheese"); // this line will update all clone object because of shallow copy

        PizzaFlavour pepperoni = new PizzaFlavour("Pepperoni");
        Pizza pepperoniPizza1 = new Pizza(5, pepperoni);
        Pizza pepperoniPizza2 = pepperoniPizza1.clone();
        Pizza pepperoniPizza3 = pepperoniPizza1.clone();
        Pizza pepperoniPizza4 = pepperoniPizza1.clone();
        Pizza pepperoniPizza5 = pepperoniPizza1.clone();

        List<Meal> order = List.of(hawaiianPizza1, hawaiianPizza2, hawaiianPizza3, hawaiianPizza4, hawaiianPizza5,
                pepperoniPizza1, pepperoniPizza2, pepperoniPizza3, pepperoniPizza4, pepperoniPizza5);
        order.stream().forEach(System.out::println);
    }
}
