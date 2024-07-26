package StructuralDesignPatterns.BridgeDesignPattern;

public class Hoodie implements ClothingItem{

    Size size;

    public Hoodie(Size size) {
        this.size = size;
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public String getType() {
        return "Hoodie";
    }
}
