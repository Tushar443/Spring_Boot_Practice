package BehavioralDesignPattern.CommandDP;

import java.util.ArrayList;
import java.util.List;

public class ItemOperationExecutor {

    List<ItemOperation> operations = new ArrayList<>();

    public void queueOperation(ItemOperation itemOperation){
        operations.add(itemOperation);
    }

    public void checkout(){
        operations.forEach(ItemOperation::execute);
    }


}
