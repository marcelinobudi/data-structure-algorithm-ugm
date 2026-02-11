package animal;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
    public void eat() {
        System.out.println("Cat " + name + " is eating food");
    }
    public void run() {
        super.run(); // using super to execute Parent code
        System.out.println("Cat " + name + " is running");
    }
}
