package StructuralDesignPatterns.BridgeDesignPattern;

public class BridgeMain {
    public static void main(){
        Hoodie hoodie = new Hoodie(new AdultSize());
        System.out.println(hoodie.getType());
        hoodie.getSize().getSize();
        Shirt shirt = new Shirt(new ChildSize());
        System.out.println(shirt.getType());
        shirt.getSize().getSize();
    }
}
