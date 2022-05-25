import java.io.IOException;

public class Main {


    public static void main(String[] args) {
        Person person = new Person("Jose Caro", 12, "Hola");
        //  Person personClone = person.clone();
        Person personClone2 = new Person(person.getName(), person.getAge(), person.getOccupation());
        try {
            Person.escribirPersona(null);
        } catch (IOException e) {
            System.out.println("IO");
        }
        System.out.println(person.getName());
        // System.out.println(personClone.getName());
        System.out.println(person.getId());
        // System.out.println(personClone.getId());
    }
}
