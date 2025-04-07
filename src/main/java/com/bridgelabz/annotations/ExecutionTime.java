package com.bridgelabz.annotations;
import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {

}
class time {

    @LogExecutionTime
    public void task1() {
        for (int i = 0; i < 1000; i++) {
            int x = i * i;
        }
    }

    @LogExecutionTime
    public void task2() {
        for (int i = 0; i < 1000000; i++) {
            double y = Math.sqrt(i);
        }
    }
}



public class ExecutionTime {

        public static void main(String[] args) throws Exception {

            Class<?> cls = time.class;
            Method[] methods=cls.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(LogExecutionTime.class)) {
                    long start = System.nanoTime();
                    method.invoke(cls.getDeclaredConstructor().newInstance());
                    long end = System.nanoTime();
                    long duration = end - start;

                    System.out.println(method.getName());
                    System.out.println( duration );
                    System.out.println();
                }
            }
        }
    }

