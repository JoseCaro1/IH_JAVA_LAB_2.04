import java.io.FileWriter;
import java.io.IOException;

public class Person {

    private int id;
    private String name;
    private int age;
    private String occupation;

    private static int idCounter = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.split(" ").length < 2 || name.split(" ").length > 4) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person person = (Person) obj;
            if ((person.getName().equals(name) && person.getAge() == age && person.occupation.equals(occupation))) {
                return true;
            }
        }

        return false;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("No debes introducir una edad negativa");
        }
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    @Override
    public String toString() {
        return name + " " + age;
    }

    @Override
    protected Person clone() {
        return new Person(name, age, occupation);
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Person(String name, int age, String occupation) {
        this.id = idCounter++;
        setName(name);
        setAge(age);
        this.occupation = occupation;
    }

    public static void escribirPersona(Person person) throws IOException {
        if(person == null) {
            throw new IllegalArgumentException();
        }
        FileWriter fileWriter = new FileWriter("person.txt");
        fileWriter.write(person.toString());
        fileWriter.close();
    }

}
