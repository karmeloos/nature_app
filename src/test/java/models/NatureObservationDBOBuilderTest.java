package models;

import models.dbo.NatureObservationDBO;
import models.dbo.builders.NatureObservationDBOBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NatureObservationDBOBuilderTest {
    @Test
    @DisplayName("should nature observation be equal other one")
    void test1() {
        byte[] photoData = new byte[0];

        NatureObservationDBO natureObservationDBO = new NatureObservationDBOBuilder("name")
                .withDescription("desc")
                .withIdCategory(10)
                .withIdLocalisation(100)
                .withPhoto(photoData)
                .build();

        assertAll(
                () -> assertEquals(natureObservationDBO.getName(), "name"),
                () -> assertEquals(natureObservationDBO.getDescription(), "desc"),
                () -> assertEquals(natureObservationDBO.getIdCategory(), 10),
                () -> assertEquals(natureObservationDBO.getIdLocalisation(), 100),
                () -> assertEquals(natureObservationDBO.getPhoto(), photoData)  //test czy obiekt jest ten sam (bez spr wartosci)
        );

    }
}