package CreationDesignPattern.AbstractFactoriesDP;

public class RoadBikeFactory implements BikeFactory{
    @Override
    public HandleBars createHandlerBar() {
        return new RoadBikeHandlebars();
    }

    @Override
    public Pedals createPedals() {
        return new RoadBikePedals();
    }

    @Override
    public Tire createTire() {
        return new RoadBikeTire();
    }
}
