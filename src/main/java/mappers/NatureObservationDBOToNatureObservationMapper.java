package mappers;

import database.IDatabase;
import helpers.ImageAdapter;
import javafx.scene.image.Image;
import models.dbo.CategoryDBO;
import models.dbo.LocalisationDBO;
import models.NatureObservation;
import models.dbo.NatureObservationDBO;

import java.io.*;

public class NatureObservationDBOToNatureObservationMapper {
    CategoryDBOToCategoryMapper categoryDBOToCategoryMapper = new CategoryDBOToCategoryMapper();
    LocalisationDBOToLocalisationMapper localisationDBOToLocalisationMapper = new LocalisationDBOToLocalisationMapper();

    public NatureObservation map(NatureObservationDBO dbo, IDatabase database){
        CategoryDBO category = database.selectCategory(dbo.getIdCategory());
        LocalisationDBO localisation = database.selectLocalisation(dbo.getIdLocalisation());
        Image photo = null;

        if (dbo.getPhoto() != null) {
            photo = new Image(new ByteArrayInputStream(dbo.getPhoto()));
        }

        return new NatureObservation(
                dbo.getId(),
                dbo.getName(),
                categoryDBOToCategoryMapper.map(category),
                localisationDBOToLocalisationMapper.map(localisation),
                dbo.getDescription(),
                new ImageAdapter(photo));
    }
}
