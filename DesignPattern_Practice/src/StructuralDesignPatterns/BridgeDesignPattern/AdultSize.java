package StructuralDesignPatterns.BridgeDesignPattern;

public class AdultSize implements Size{
    @Override
    public void getSize() {
        System.out.println("Adult size");
    }
}
