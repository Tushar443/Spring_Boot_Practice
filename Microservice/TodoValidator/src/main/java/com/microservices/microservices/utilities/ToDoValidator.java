package com.microservices.microservices.utilities;

import com.microservices.microservices.entity.ToDo;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ToDoValidator implements Validator
{
    @Override
    public boolean supports(Class<?> clazz) {
        return ToDo.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ToDo toDo= (ToDo) target;
        String priority = toDo.getPriority();

        if(!"high".equals(priority) && !"low".equals(priority)){
            errors.rejectValue("priority","Priority must be high or low!");
        }
    }
}
