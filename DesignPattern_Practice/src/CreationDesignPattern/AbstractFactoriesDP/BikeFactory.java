package CreationDesignPattern.AbstractFactoriesDP;

public interface BikeFactory {
    HandleBars createHandlerBar();
    Pedals createPedals();
    Tire createTire();
}
