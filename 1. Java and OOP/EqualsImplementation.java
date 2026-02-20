import animal.Dog;
import animal.Cat;

public class EqualsImplementation {
    public static void main(String[] args) {
        System.out.println("#Eksperimen 1");
        Dog dog1 = new Dog("Blacky");
        Cat cat1 = new Cat("Katie");
        System.out.println(dog1.equals(cat1)); // FALSE
        System.out.println("#Eksperimen 2");
        Dog dog2 = new Dog("Blacky");
        Cat cat2 = new Cat("Blacky");
        System.out.println(dog2.equals(cat2)); // TRUE
    }
}
