package mappers;

import models.Category;
import models.dbo.CategoryDBO;

public class CategoryToCategoryDBOMapper {
    public CategoryDBO map(Category category){
        return new CategoryDBO(category.getName());
    }
}
