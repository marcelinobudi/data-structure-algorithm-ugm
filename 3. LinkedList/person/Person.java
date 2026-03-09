package person;

public class Person {
    public String name;
    public String occupation;
    public byte age;
    public Person(String name, String occupation, byte age){
        this.name = name;
        this.occupation = occupation;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person(name='" + this.name + "', occupation='" + this.occupation + "', age='" + this.age + "')";
    }
}
