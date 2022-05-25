
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    Person person;
    Person personClone;

    @BeforeEach
    public void init() {
        person = new Person("Jose Alfonso Caro Romero", 20, "Assistant Teacher");
        personClone = person.clone();
    }

    // Comienzo TEST Age
    @Test
    @DisplayName("Validacion edad 0")
    public void person_setAge_zero_age() {
        assertEquals(0, new Person("Jose Caro", 0, "Assistant Teacher").getAge());
    }

    @Test
    @DisplayName("Validacion edad positiva")
    public void person_setAge_positive_age() {
        assertEquals(20, new Person("Jose Caro", 20, "Assistant Teacher").getAge());
    }

    @Test
    @DisplayName("Validacion edad negativa")
    public void person_setAge_negative_age() {
        assertThrows(IllegalArgumentException.class, () -> new Person("Jose", -1, "Assistant Teacher"));
    }

    //Comienzo TEST name
    @Test
    @DisplayName("Validacion nombre una palabra")
    public void person_setName_one_word() {
        assertThrows(IllegalArgumentException.class, () -> new Person("Jose", 20, "Assistant Teacher"));
    }

    @Test
    @DisplayName("Validacion nombre mas de cuatro palabras")
    public void person_setName_more_than_four_words() {
        assertThrows(IllegalArgumentException.class, () -> new Person("Jose Alfonso Caro Romero Hola", 20, "Assistant Teacher"));
    }

    @Test
    @DisplayName("Validacion nombre cadena vacia")
    public void person_setName_empty_words() {
        assertThrows(IllegalArgumentException.class, () -> new Person("", 20, "Assistant Teacher"));
    }

    @Test
    @DisplayName("Validacion nombre nulo")
    public void person_setName_null_words() {
        assertThrows(IllegalArgumentException.class, () -> new Person(null, 20, "Assistant Teacher"));
    }

    @Test
    @DisplayName("Validacion nombre correcto")
    public void person_setName_correct_words() {
        assertEquals("Jose Caro", new Person("Jose Caro", 20, "Assistant Teacher").getName());
        assertEquals("Jose Caro Romero", new Person("Jose Caro Romero", 20, "Assistant Teacher").getName());
        assertEquals("Jose Alfonso Caro Romero", new Person("Jose Alfonso Caro Romero", 20, "Assistant Teacher").getName());
    }

    //Comienzo validacion clone

    @Test
    @DisplayName("Validacion clone correcto")
    public void person_check_clone() {
        Person person = new Person("Jose Alfonso Caro Romero", 20, "Assistant Teacher");
        Person personClone = person.clone();
        assertEquals("Jose Alfonso Caro Romero", personClone.getName());
        assertEquals(20, personClone.getAge());
        assertEquals("Assistant Teacher", personClone.getOccupation());
        assertNotEquals(person.clone().getId(), personClone.getId());
    }

    //Comienzo TEST equals
    @Test
    @DisplayName("Validacion equals no introducir person")
    public void person_check_equals_not_person() {
        assertFalse(person.equals(new Object()));
    }

    @Test
    @DisplayName("Validacion equals personas iguales")
    public void person_check_equals_same_person() {
        assertTrue(person.equals(personClone));
    }

    @Test
    @DisplayName("Validacion equals personas diferentes")
    public void person_check_equals_different_person() {

        personClone.setName("Alba silla");
        assertFalse(person.equals(personClone));
    }


    //Comienzo TEST

    @Test
    @DisplayName("Validacion que se escribe correctamente el fichero")
    public void person_escribirPersona_successfully() throws IOException {
        Person.escribirPersona(person);
        String lineasTexto = "";
        BufferedReader bufferedReader = new BufferedReader(new FileReader("person.txt"));
        while ((lineasTexto += bufferedReader.readLine()) == null) ;
        assertEquals("Jose Alfonso Caro Romero 20", lineasTexto);
    }

    @Test
    @DisplayName("Validacion escribirPersona introducir null")
    public void person_escribirPersona_person_null() throws IOException {
        assertThrows(IllegalArgumentException.class, () -> Person.escribirPersona(null));
    }

}
