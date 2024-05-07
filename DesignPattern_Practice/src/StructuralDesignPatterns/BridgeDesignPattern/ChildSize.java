package StructuralDesignPatterns.BridgeDesignPattern;

public class ChildSize implements Size {
    @Override
    public void getSize() {
        System.out.println("Child Size");
    }
}
