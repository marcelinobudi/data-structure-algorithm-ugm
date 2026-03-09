
import person.*;
public class Implementation {
    public static void main(String[] args) {
        SimpleLinkedList<Person> persons = new SimpleLinkedList<>();
        persons.insertFirst(new Person("Marcel", "Student", (byte)18));
        persons.insertFirst(new Person("Kurose", "Researcher", (byte)27));
        persons.insertFirst(new Person("Rose", "Teaching Assistant", (byte)23));
        persons.display();
        boolean searchingResult = persons.search(new Person("Kurose", "Researcher", (byte)27));
        System.out.println("Hasil pencarian: " + searchingResult);
    }
}
