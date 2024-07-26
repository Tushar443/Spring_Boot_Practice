package CreationDesignPattern.AbstractFactoriesDP;

public class Bike {
    private HandleBars handlebars;
    private Pedals pedals;
    private Tire frontTire;
    private Tire backTire;

    public Bike(HandleBars handlebars, Pedals pedals, Tire frontTire, Tire backTire) {
        this.handlebars = handlebars;
        this.pedals = pedals;
        this.frontTire = frontTire;
        this.backTire = backTire;
    }

    public HandleBars getHandlebars() {
        return handlebars;
    }

    public Pedals getPedals() {
        return pedals;
    }

    public Tire getFrontTire() {
        return frontTire;
    }

    public Tire getBackTire() {
        return backTire;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "handlebars=" + handlebars.getType() +
                ", pedals=" + pedals.getType() +
                ", frontTire=" + frontTire.getWidth() +
                ", backTire=" + backTire.getWidth() +
                '}';
    }
}
