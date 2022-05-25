import java.util.ArrayList;

public class PersonList {

    public PersonList(ArrayList<Person> persons) {
        this.persons = persons;
    }

    private ArrayList<Person> persons;

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public Person findByName(String name) {
        Person person = null;
        if (name == null || name.split(" ").length < 2 || name.split(" ").length > 4) {
            throw new IllegalArgumentException();
        }
        for (Person personToFind : persons) {
            if (personToFind.getName().equals(name)) {
                person = personToFind;
                return person;
            }
        }
        throw new UnsupportedOperationException("No se ha encontrado persona");


    }
}
