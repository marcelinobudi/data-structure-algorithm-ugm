package animal;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
    public void eat() {
        System.out.println("Dog " + name + " is eating food");
    }
    public void run() {
        System.out.println("Dog " + name + " is running");
    }
}
