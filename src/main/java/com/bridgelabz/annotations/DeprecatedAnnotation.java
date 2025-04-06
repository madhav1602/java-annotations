package com.bridgelabz.annotations;

class LegacyAPI{
    @Deprecated
    public void oldfeature(){
        System.out.println("old feature");
    }
    public void newfeature(){
        System.out.println("new feature");
    }
}
public class DeprecatedAnnotation {
    public static void main(String[] args) {
        LegacyAPI obj1=new LegacyAPI();
        obj1.oldfeature();
    }
}
