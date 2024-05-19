package CreationDesignPattern.AbstractFactoriesDP;

public class AbstractMain {
    public static void main(){
        Bike roadBike = buildBike("road");
        Bike mountainBike = buildBike("mountain");
        System.out.println("Road Bike = "+roadBike);
        System.out.println("Mountain Bike = "+mountainBike);
    }

    private static Bike buildBike(String bikeType) {
        BikeFactory bikeFactory = FactoryMaker.createFactory(bikeType);
        HandleBars handleBars = bikeFactory.createHandlerBar();
        Pedals pedals = bikeFactory.createPedals();
        Tire front = bikeFactory.createTire();
        Tire back = bikeFactory.createTire();
        return new Bike(handleBars,pedals,front,back);
//        if (bikeType.equalsIgnoreCase("ROAD")) {
//            RoadBikeFactory roadBikeFactory = new RoadBikeFactory();
//            HandleBars handleBars = roadBikeFactory.createHandlerBar();
//            Pedals pedals = roadBikeFactory.createPedals();
//            Tire front = roadBikeFactory.createTire();
//            Tire back = roadBikeFactory.createTire();
//            return new Bike(handleBars,pedals,front,back);
//        } else if (bikeType.equalsIgnoreCase("MOUNTAIN")) {
//            MountainBikeFacotry mountainBikeFacotry = new MountainBikeFacotry();
//            HandleBars handleBars = mountainBikeFacotry.createHandlerBar();
//            Pedals pedals = mountainBikeFacotry.createPedals();
//            Tire front = mountainBikeFacotry.createTire();
//            Tire back = mountainBikeFacotry.createTire();
//            return new Bike(handleBars,pedals,front,back);
//        } else {
//            throw new IllegalArgumentException("Bike type not supported");
//        }
    }
}
