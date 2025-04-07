package com.bridgelabz.annotations;
import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface veryimportant{
    String level() default "High";
}

class Tasks{
    @veryimportant(level="Low")
    public void task1(){
        System.out.println("doing task1");
    }
    @veryimportant(level="Medium")
    public void task2(){
        System.out.println("doing task2");
    }
    @veryimportant
    public void task3(){
        System.out.println("doing task3");
    }
}
public class Important {
    public static void main(String[] args) {
        Class<?> cls=Tasks.class;
        Method[] methods=cls.getMethods();

        for(Method method: methods){
            if(method.isAnnotationPresent(veryimportant.class)){
                veryimportant vi=method.getAnnotation(veryimportant.class);
                if(vi.level().equals("High") || vi.level().equals("Medium")){
                    try{
                        System.out.println(method.getName());
                        method.invoke(cls.getDeclaredConstructor().newInstance());
                        System.out.println(vi.level());
                        System.out.println();
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }

                }
                else{
                    System.out.println(method.getName());
                    System.out.println("Task importance is low");
                    System.out.println();
                }
            }
        }
    }
}
