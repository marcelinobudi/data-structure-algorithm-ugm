package animal;
public class Animal {
    public String name;
    public  Animal(String name){
        this.name = name;
    }
    public void eat(){
        System.out.println("Animal " + name + " is eating food");
    }
    public void run() {
        System.out.println("Animal " +name + " is running");
    }
}
