package StructuralDesignPatterns.FlyWeightDP;

import java.util.HashMap;
import java.util.Map;

public class OrderFactory {
    public static final Map<String,Order> orderCache= new HashMap<>();

    public static Order createOrder(String orderName){
//        if(orderCache.containsKey(orderName)){
//            return orderCache.get(orderName);
//        }else{
//            Order order = new Order(orderName);
//            orderCache.put(orderName,order);
//            return order;
//        }
        /**
         * All above code done for us
         */
        return orderCache.computeIfAbsent(orderName,Order::new);
    }
}
