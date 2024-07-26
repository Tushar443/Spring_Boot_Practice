package CreationDesignPattern.AbstractFactoriesDP;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class FactoryMaker {

    private static final Map<String, Supplier<BikeFactory>> map = new HashMap<>();

    static {
        map.put("road",RoadBikeFactory::new);
        map.put("mountain",MountainBikeFacotry::new);
    }
    public static BikeFactory createFactory(String bikeType){
        if(map.get(bikeType) != null){
            return map.get(bikeType).get();
        }else{
            throw new IllegalArgumentException("Not supported");
        }
    }
}
