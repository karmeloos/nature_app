package mappers;

import mocks.DatabaseMock;
import models.*;
import models.dbo.CategoryDBO;
import models.dbo.LocalisationDBO;
import models.dbo.NatureObservationDBO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NatureObservationDBOToNatureObservationTests {
    @Test
    @DisplayName("should NatureObservationDBO be mapped to NatureObservation successfully when all arguments are given")
    void test1() {
        byte[] photoData = new byte[0];

        List<CategoryDBO> categoryDBOs = new LinkedList<>(Arrays.asList(new CategoryDBO(3, "Przyroda_Mock")));
        List<LocalisationDBO> localisationDBOs = new LinkedList<>(Arrays.asList(new LocalisationDBO(2, "Kraków_Mock")));

        DatabaseMock databaseMock = new DatabaseMock(categoryDBOs, localisationDBOs);

        NatureObservationDBOToNatureObservationMapper tested = new NatureObservationDBOToNatureObservationMapper();
        NatureObservation result = tested.map(new NatureObservationDBO(
                1, "Grad",
                2,
                3,
                "Śr.3 cm",
                photoData),
                databaseMock);
        assertAll(
                () -> assertEquals(1, result.getId()),
                () -> assertEquals("Grad", result.getName()),
                () -> assertEquals("Kraków_Mock", result.getLocalisation().getName()),
                () -> assertEquals("Przyroda_Mock", result.getCategory().getName()),
                () -> assertEquals("Śr.3 cm", result.getDescription()),
                () -> assertNotNull(result.getPhoto().getImage())
        );
    }
}