package facades;

import mocks.DatabaseMock;
import models.Category;
import models.dbo.CategoryDBO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryFacadesTests {
    @Test
    @DisplayName("should add categorydbo to database")
    void test1() {
        DatabaseMock databaseMock = new DatabaseMock();

        CategoryFacade tested = new CategoryFacade(databaseMock);
        tested.add(new Category ("Zwierzęta"));

        List <CategoryDBO> result = databaseMock.getCategories().stream().filter(c -> c.getName() == "Zwierzęta").collect(Collectors.toList());

        assertAll(
                () -> assertEquals(1, result.size()),
                () -> assertEquals("Zwierzęta", result.get(0).getName())
        );
    }
}
