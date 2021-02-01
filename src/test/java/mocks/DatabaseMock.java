package mocks;

import database.IDatabase;
import models.dbo.CategoryDBO;
import models.dbo.LocalisationDBO;
import models.dbo.NatureObservationDBO;

import java.util.LinkedList;
import java.util.List;

public class DatabaseMock implements IDatabase {
    private List <CategoryDBO> categories;
    private List <LocalisationDBO> localisations;

    public List<CategoryDBO> getCategories() {
        return categories;
    }

    public List<LocalisationDBO> getLocalisations() {
        return localisations;
    }

    public DatabaseMock(List <CategoryDBO> cat, List <LocalisationDBO> loc) {
        this.categories = cat;
        this.localisations = loc;
    }

    public DatabaseMock() {
        this.categories = new LinkedList<CategoryDBO>();
        this.localisations = new LinkedList<LocalisationDBO>();
    }

    @Override
    public boolean insertObservation(NatureObservationDBO dbo) {
        return true;
    }

    @Override
    public boolean insertLocalisation(LocalisationDBO locDBO) {
        localisations.add(locDBO);
        return true;
    }

    @Override
    public boolean insertCategory(CategoryDBO catDBO) {
        categories.add(catDBO);

        return true;
    }

    @Override
    public List<NatureObservationDBO> selectAllObservations() {
        return null;
    }

    @Override
    public List<LocalisationDBO> selectLocalisations() {
        return null;
    }

    @Override
    public List<CategoryDBO> selectCategories() {
        return null;
    }

    @Override
    public CategoryDBO selectCategory(int id) {
        for(int i = 0; i < categories.size(); i++){
            if(categories.get(i).getId() == id){
                return categories.get(i);
            }
        }
        return null;
    }

    @Override
    public LocalisationDBO selectLocalisation(int id) {
        for(int i = 0; i < localisations.size(); i++){
            if(localisations.get(i).getId() == id){
                return localisations.get(i);
            }
        }
        return null;
    }
}
