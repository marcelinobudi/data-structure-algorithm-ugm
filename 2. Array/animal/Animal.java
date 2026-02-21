package animal;
public class Animal {
    public String name;
    public String type;
    public  Animal(String name){
        this.name = name;
    }
    public void eat(){
        System.out.println("Animal " + name + " is eating food");
    }
    public void run() {
        System.out.println("Animal " +name + " is running");
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof Animal)) return false;
        Animal animal = (Animal) obj;
        return this.name == animal.name;
    }
}
