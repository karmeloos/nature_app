package mappers;

import models.Localisation;
import models.dbo.LocalisationDBO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LocalisationDBOToLocalisationMapperTests {
    @Test
    @DisplayName("should localisationDBO be mapped to localisation successfully when name is given")
    void test1() {
        LocalisationDBOToLocalisationMapper tested = new LocalisationDBOToLocalisationMapper();
        Localisation result = tested.map(new LocalisationDBO("Kraków"));
        assertAll(
                () -> assertEquals("Kraków", result.getName()),
                () -> assertEquals(0, result.getId()));

    }

    @Test
    @DisplayName("should localisationDBO be mapped to localisation successfully when name and id is given")
    void test2() {
        LocalisationDBOToLocalisationMapper tested = new LocalisationDBOToLocalisationMapper();
        Localisation result = tested.map(new LocalisationDBO(8, "Kraków"));
        assertAll(
                () -> assertEquals("Kraków", result.getName()),
                () -> assertEquals(8, result.getId()));

    }

    @Test
    @DisplayName("should localisationDBO be mapped to localisation unsuccessfully when name and id differ")
    void test3() {
        LocalisationDBOToLocalisationMapper tested = new LocalisationDBOToLocalisationMapper();
        Localisation result = tested.map(new LocalisationDBO(3, "Kraków"));
        assertAll(
                () -> assertNotEquals("Warszawa", result.getName()),
                () -> assertNotEquals(0, result.getId()));

    }
}
