package BehavioralDesignPattern.IteratorDP;

public class MainClass {

    public static void main(){
        var pen = new ItemIT("Pen", 20);
        var pencil = new ItemIT("Pencil", 0);
        var eraser = new ItemIT("Eraser", 15);

        Inventory inventory = new Inventory(pen,pencil,eraser);
        StockIterator stockIterator = (StockIterator) inventory.iterator();
        while (stockIterator.hasNext()){
            ItemIT itemIT = stockIterator.next();
            System.out.println(itemIT);
        }
    }
}
