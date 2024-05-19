package BehavioralDesignPattern.IteratorDP;

import java.util.Iterator;

public class StockIterator implements Iterator<ItemIT> {

    private Inventory inventory;
    private int index;

    public StockIterator(Inventory inventory) {
        this.inventory = inventory;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        ItemIT[] itemITS = inventory.getItemITS();
        return index < itemITS.length;
    }

    @Override
    public ItemIT next() {
        ItemIT[] itemITS = inventory.getItemITS();
        if(hasNext()){
            ItemIT itemIT = itemITS[index++];
            if(itemIT.getQuantity() > 0 ){
                return itemIT;
            }else{
                return next();
            }
        }else
            return null;
    }
}
