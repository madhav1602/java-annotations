package com.bridgelabz.annotations;
import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo{
    String priority() default "medium";
    String assignedTo();
}

class TaskManager{

    @TaskInfo(priority = "High", assignedTo = "Madhav")
    public void payment(){
        System.out.println("Payment");
    }

    @TaskInfo(priority = "low", assignedTo = "Simran")
    public void feedback(){
        System.out.println("feedback");
    }
}
public class TaskInfoo{
    public static void main(String[] args) {
        Class<TaskManager> cls=TaskManager.class;
        Method[] methods=cls.getDeclaredMethods();

        for(Method method: methods){
            if(method.isAnnotationPresent(TaskInfo.class)){
                TaskInfo ti=method.getAnnotation(TaskInfo.class);
                System.out.println(method.getName());
                System.out.println(ti.priority());
                System.out.println(ti.assignedTo());
                System.out.println();
            }
        }
    }

}