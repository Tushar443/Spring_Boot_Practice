package StructuralDesignPatterns.BridgeDesignPattern;

public class Shirt implements ClothingItem{

    Size size;

    public Shirt(Size size) {
        this.size = size;
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public String getType() {
        return "Shirt";
    }
}
