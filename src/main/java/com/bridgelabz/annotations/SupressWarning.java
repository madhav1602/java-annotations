package com.bridgelabz.annotations;
import java.util.ArrayList;
import java.util.List;

public class SupressWarning {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("Java");
        list.add(101);
        list.add(true);


        for (Object item : list) {
            System.out.println(item);
        }
    }
}
