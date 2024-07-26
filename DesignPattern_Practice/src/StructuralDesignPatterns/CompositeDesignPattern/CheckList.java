package StructuralDesignPatterns.CompositeDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class CheckList implements Completable{
    List<TodoItem> todoItems = new ArrayList<>();

    public void addTodoItem(TodoItem todoItem) {
        todoItems.add(todoItem);
    }

    @Override
    public void isComplete() {
        todoItems.forEach(TodoItem::isComplete);
    }
}
