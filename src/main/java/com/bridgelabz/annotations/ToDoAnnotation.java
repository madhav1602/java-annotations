package com.bridgelabz.annotations;
import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
    String status() default "Completed";
}


class Taskss {

    @Todo(task = "Payment", assignedTo = "Madhav", priority = "HIGH", status="Pending")
    public void payments() {

    }

    @Todo(task = "Feedback", assignedTo = "Simran")
    public void feedback() {

    }

    @Todo(task = "Order", assignedTo = "Dhruv", priority = "LOW", status = "Pending")
    public void order() {

    }
}

public class ToDoAnnotation {
    public static void main(String[] args) {
        Class<?> cls=Taskss.class;
        Method[] methods=cls.getDeclaredMethods();

        for(Method method: methods){
            if(method.isAnnotationPresent(Todo.class)){
                Todo td=method.getAnnotation(Todo.class);
                if(td.status().equals("Pending")){
                    System.out.println("PENDING TASK");
                    System.out.println(td.task());
                    System.out.println(td.assignedTo());
                    System.out.println(td.priority());
                    System.out.println();
                }
            }
        }
    }
}
