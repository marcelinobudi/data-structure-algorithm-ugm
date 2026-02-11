import java.lang.reflect.Method;

import animal.*;

/// Polymorphism
/// Treat objects of different classes in the same way
/// GEEKSFORGEEKS (2026)

/// Advantages of Polymorphism

//     Code Reusability: The same method or class works with different object types.
//     Flexibility: Different objects can be treated as a common superclass type.
//     Abstraction: Enables working with general types (abstract classes or interfaces) instead of concrete classes.
//     Dynamic Behavior: Method calls are resolved at runtime based on the actual object type.

// Disadvantages of Polymorphism

//     It can make more difficult to understand the behavior of an object.
//     This may cause performance issues, as polymorphic behavior may require additional computations at runtime.

public class Polymorphism {
    public static void main(String[] args) {
        Animal animal = new Animal("Yatnow");
        animal.eat();
        System.out.println("#1 Experiment");
        Dog dog1 = new Dog("anjing");
        dog1.eat();
        System.out.println("#2 Experiment");
        Animal dog2 = new Dog("anjing");
        dog2.eat();
        System.out.println("#3 Experiment");
        Animal dog3 = (Animal) dog1; // call Dog object and force ANIMAL
        dog3.eat(); // still implementing Dog classes, not Animal base classes
        
        System.out.println("#4 Experiment");
        Cat cat1 = new Cat("Cattie");
        cat1.eat();
        System.out.println("#5 Experiment");
        // Cat cat2 = (Animal) dog1; // ERROR
        System.out.println("Error: force dog2 into Cat classes");
        System.out.println("#6 Experiment");
        Animal animal2 = new Cat("Kitten");
        animal2.eat();
        animal2 = new Dog("Kitten"); // [animal2] kitten is TRANSFORMED into DOG!!
        animal2.eat();
        System.out.println("#7 super.run() Experiment");
        Cat cat3 = new Cat("Kiru");
        cat3.run();
    }
}
