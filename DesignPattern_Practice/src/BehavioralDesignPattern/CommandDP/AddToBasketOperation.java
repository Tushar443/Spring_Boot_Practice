package BehavioralDesignPattern.CommandDP;

public class AddToBasketOperation implements ItemOperation{
    private Item item;

    public AddToBasketOperation(Item item){
        this.item = item;
    }

    @Override
    public void execute() {
        item.addToBasket();
    }
}
