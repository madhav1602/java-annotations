package com.bridgelabz.annotations;


class Animal {
    public void makeSound() {
        System.out.println("animal");
    }
}


class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("dog");
    }
}

// Main class
public class OverRide {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.makeSound();
    }
}

