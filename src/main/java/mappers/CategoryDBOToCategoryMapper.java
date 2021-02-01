package mappers;

import models.Category;
import models.dbo.CategoryDBO;

public class CategoryDBOToCategoryMapper {
    public Category map(CategoryDBO categorydbo){
        return new Category(categorydbo.getId(), categorydbo.getName());
    }
}
