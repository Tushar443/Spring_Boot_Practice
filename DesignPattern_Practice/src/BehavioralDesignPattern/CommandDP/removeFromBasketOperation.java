package BehavioralDesignPattern.CommandDP;

public class removeFromBasketOperation implements ItemOperation{

    private Item item;

    public removeFromBasketOperation(Item item) {
        this.item = item;
    }

    @Override
    public void execute() {
        item.removeFromBasket();
    }
}
