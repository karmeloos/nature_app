package facades;

import mocks.DatabaseMock;
import models.Localisation;
import models.dbo.LocalisationDBO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalisationFacadesTests {
    @Test
    @DisplayName("should add localisationdbo to database")
    void test1() {
        DatabaseMock databaseMock = new DatabaseMock();

        LocalisationFacade tested = new LocalisationFacade(databaseMock);
        tested.add(new Localisation("Kraków"));

        List<LocalisationDBO> result = databaseMock.getLocalisations().stream().filter(l -> l.getName() == "Kraków").collect(Collectors.toList());

        assertAll(
                () -> assertEquals(1, result.size()),
                () -> assertEquals("Kraków", result.get(0).getName())
        );
    }
}
