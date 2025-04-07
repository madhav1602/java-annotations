package com.bridgelabz.annotations;
import java.lang.reflect.*;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface rolesallowed{
    String role();
}

class resources{
    @rolesallowed(role="ADMIN")
    public void resource1(){

    }

    @rolesallowed(role="INTERN")
    public void resource2(){

    }
}
public class Roles {
    public static void main(String[] args) {
        Class<?> cls=resources.class;
        Method[] methods=cls.getDeclaredMethods();
        String currentRole="INTERN";

        for(Method method: methods){
            if(method.isAnnotationPresent(rolesallowed.class)){
                rolesallowed ra=method.getAnnotation(rolesallowed.class);
                if(ra.role().equals(currentRole)){
                    System.out.println("Permission granted to "+currentRole+" for "+method.getName());
                }
                else{
                    System.out.println("Permission not granted to "+currentRole+" for "+method.getName()+". Requires "+ra.role()+" access.");
                }

            }
        }
    }
}
