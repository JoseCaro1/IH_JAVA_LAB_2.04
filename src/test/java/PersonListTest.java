import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonListTest {

    PersonList personList = new PersonList(new ArrayList<>());

    @BeforeEach
    public void init() {
        personList.addPerson(new Person("Jose Caro", 20, "Assistant Teacher"));
    }

    //Comienzo TEST name
    @Test
    @DisplayName("Validacion nombre una palabra")
    public void personList_findByName_one_word() {
        assertThrows(IllegalArgumentException.class, () -> personList.findByName("Jose"));
    }

    @Test
    @DisplayName("Validacion nombre mas de cuatro palabras")
    public void personList_findByName_more_than_four_words() {
        assertThrows(IllegalArgumentException.class, () -> personList.findByName("Jose Alfonso Caro Romero Mi"));
    }

    @Test
    @DisplayName("Validacion nombre cadena vacia")
    public void personList_findByName_empty_words() {
        assertThrows(IllegalArgumentException.class, () -> personList.findByName(""));
    }

    @Test
    @DisplayName("Validacion nombre nulo")
    public void personList_findByName_null_words() {
        assertThrows(IllegalArgumentException.class, () -> personList.findByName(null));
    }

    @Test
    @DisplayName("Validacion encontrar la persona satisfactoriamente")
    public void personList_findByName_successfully() {
        assertEquals("Jose Caro", personList.findByName("Jose Caro").getName());
    }

}
