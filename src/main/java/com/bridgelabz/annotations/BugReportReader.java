package com.bridgelabz.annotations;
import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport{
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports{
    BugReport[] value();
}

class Bug{
    @BugReport(description = "bug type 1")
    @BugReport(description = "bug type 2")
    public void display(){
        System.out.println("printing bug");
    }

    @BugReport(description = "bug type 3")
    public void check(){
        System.out.println("check");
    }
}

public class BugReportReader {
    public static void main(String[] args) {
        Class<?> cls=Bug.class;
        Method[] methods=cls.getDeclaredMethods();

        for(Method method: methods){
            if(method.isAnnotationPresent(BugReports.class)){
                BugReports report=method.getAnnotation(BugReports.class);
                for(BugReport bug: report.value()){
                    try{
                        System.out.println(method.getName());
                        method.invoke(cls.getDeclaredConstructor().newInstance());
                        System.out.println(bug.description());
                        System.out.println();
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());

                    }

                }
            }
            else if (method.isAnnotationPresent(BugReport.class)) {

                BugReport bug = method.getAnnotation(BugReport.class);
                System.out.println("Method: " + method.getName());
                System.out.println("Bug Description: " + bug.description());
                System.out.println();
            }
        }


    }
}
