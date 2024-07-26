package BehavioralDesignPattern.IteratorDP;

import java.util.Iterator;

public class Inventory implements Iterable<ItemIT> {

    private ItemIT[] itemITS;

    public Inventory(ItemIT... itemITS) {
        this.itemITS = itemITS;
    }

    @Override
    public Iterator<ItemIT> iterator() {
        return new StockIterator(this);
    }

    public ItemIT[] getItemITS() {
        return itemITS;
    }
}
