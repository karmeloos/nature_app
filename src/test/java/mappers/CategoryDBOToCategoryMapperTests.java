package mappers;

import models.Category;
import models.dbo.CategoryDBO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryDBOToCategoryMapperTests {
    @Test
    @DisplayName("should categoryDBO be mapped to category successfully when name is given")
    void test1() {
        CategoryDBOToCategoryMapper tested = new CategoryDBOToCategoryMapper();
        Category result = tested.map(new CategoryDBO("Przyroda"));
        assertAll(
                () -> assertEquals("Przyroda", result.getName()),
                () -> assertEquals(0, result.getId()));

    }

    @Test
    @DisplayName("should categoryDBO be mapped to category successfully when name and id is given")
    void test2() {
        CategoryDBOToCategoryMapper tested = new CategoryDBOToCategoryMapper();
        Category result = tested.map(new CategoryDBO(3, "Przyroda"));
        assertAll(
                () -> assertEquals("Przyroda", result.getName()),
                () -> assertEquals(3, result.getId()));

    }

    @Test
    @DisplayName("Verification if the system sees differences in the arguments")
    void test3() {
        CategoryDBOToCategoryMapper tested = new CategoryDBOToCategoryMapper();
        Category result = tested.map(new CategoryDBO(3, "Przyroda"));
        assertAll(
                () -> assertNotEquals("Przyroda_1", result.getName()),
                () -> assertNotEquals(0, result.getId()));

    }
}
