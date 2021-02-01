package database;

import models.dbo.CategoryDBO;
import models.dbo.LocalisationDBO;
import models.dbo.NatureObservationDBO;

import java.util.List;

public interface IDatabase {
    boolean insertObservation(NatureObservationDBO dbo);
    boolean insertLocalisation(LocalisationDBO locDBO);
    boolean insertCategory(CategoryDBO catDBO);
    List<NatureObservationDBO> selectAllObservations();
    List<LocalisationDBO> selectLocalisations();
    List<CategoryDBO> selectCategories();

    CategoryDBO selectCategory(int id);
    LocalisationDBO selectLocalisation(int id);
}
