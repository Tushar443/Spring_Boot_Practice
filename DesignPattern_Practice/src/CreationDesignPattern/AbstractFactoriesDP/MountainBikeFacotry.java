package CreationDesignPattern.AbstractFactoriesDP;

public class MountainBikeFacotry implements BikeFactory{
    @Override
    public HandleBars createHandlerBar() {
        return new MountainBikeHandlebars();
    }

    @Override
    public Pedals createPedals() {
        return new MountainBikePedals();
    }

    @Override
    public Tire createTire() {
        return new MountainBikeTire();
    }
}
