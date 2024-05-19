package BehavioralDesignPattern.CommandDP;

public class CommandMain {
    public static void main(){
        var item1 = new Item(1);
        var item2 = new Item(2);
        var item3 = new Item(3);

        ItemOperationExecutor itemOperationExecutor = new ItemOperationExecutor();
        itemOperationExecutor.queueOperation(new AddToBasketOperation(item1));
        itemOperationExecutor.queueOperation(new AddToBasketOperation(item2));
        itemOperationExecutor.queueOperation(new AddToBasketOperation(item3));
        itemOperationExecutor.queueOperation(new removeFromBasketOperation(item2));

        itemOperationExecutor.checkout();
    }
}
