package StructuralDesignPatterns.ProxyDP;

public class User {
    private final String name;
    private final boolean isPremium;

    public User(String name,boolean isPremium) {
        this.name = name;
        this.isPremium = isPremium;
    }

    public String getName() {
        return name;
    }

    public Boolean getPremium() {
        return isPremium;
    }
}
