package facades;

import database.IDatabase;
import mappers.CategoryDBOToCategoryMapper;
import mappers.CategoryToCategoryDBOMapper;
import models.Category;
import models.dbo.CategoryDBO;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryFacade extends Facade<Category> {
    CategoryDBOToCategoryMapper categoryDBOToCategoryMapper = new CategoryDBOToCategoryMapper();
    CategoryToCategoryDBOMapper categoryToCategoryDBOMapper = new CategoryToCategoryDBOMapper();

    public CategoryFacade(IDatabase database) {
        super(database);
    }

    @Override
    public void add(Category obj) {
        CategoryDBO dbo = categoryToCategoryDBOMapper.map(obj);

        database.insertCategory(dbo);
    }

    @Override
    public List<Category> getAll() {
        List <CategoryDBO> categoryDBOs = database.selectCategories();
        return categoryDBOs.stream().map(s -> categoryDBOToCategoryMapper.map(s)).collect(Collectors.toList());
    }
}




