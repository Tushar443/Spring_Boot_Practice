package StructuralDesignPatterns.CompositeDesignPattern;

public class TodoItem implements Completable{
    private final String description;
    private boolean completed = false;

    public TodoItem(String description) {
        this.description = description;
    }

    public void complete() {
        completed = true;
    }

    @Override
    public void isComplete() {
        System.out.println(description + " " + completed);
    }
}
