package StructuralDesignPatterns.FlyWeightDP;

public class FlyWeightMain {
    public static void main(){
        var pizza1 = OrderFactory.createOrder("pizza");
        var pizza2 = OrderFactory.createOrder("pizza");
        var pizza3 = OrderFactory.createOrder("pizza");

        System.out.println(pizza1);
        System.out.println(pizza2);
        System.out.println(pizza3);

        var burger1 = OrderFactory.createOrder("burger");
        var burger2 = OrderFactory.createOrder("burger");
        var burger3 = OrderFactory.createOrder("burger");
        System.out.println(burger1);
        System.out.println(burger2);
        System.out.println(burger3);
    }
}
