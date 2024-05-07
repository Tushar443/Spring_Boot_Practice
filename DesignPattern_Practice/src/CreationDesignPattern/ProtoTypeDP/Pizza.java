package CreationDesignPattern.ProtoTypeDP;

public class Pizza extends Meal{
    private PizzaFlavour flavor;

    public Pizza(int price, PizzaFlavour flavor) {
        super(price);
        this.flavor = flavor;
    }

    public PizzaFlavour getFlavor() {
        return flavor;
    }

    public void setFlavor(PizzaFlavour flavor) {
        this.flavor = flavor;
    }


    @Override
    public String toString() {
        return "Pizza{" +
                "price='" + super.getPrice() + '\'' +
                "flavor='" + flavor + '\'' +
                '}';
    }

    @Override
    public Pizza clone() {
        return new Pizza(this.getPrice(),this.getFlavor());
    }
}
