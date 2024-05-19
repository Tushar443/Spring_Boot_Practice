package BehavioralDesignPattern.IteratorDP;

public class ItemIT {
    private final String name;
    private final int quantity;

    public ItemIT(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }


    public int getQuantity() {
        return this.quantity;
    }

    @Override
    public String toString() {
        return "ItemIT{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
