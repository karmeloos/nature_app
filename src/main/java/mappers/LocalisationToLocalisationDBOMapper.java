package mappers;

import models.Localisation;
import models.dbo.LocalisationDBO;

public class LocalisationToLocalisationDBOMapper {
    public LocalisationDBO map(Localisation localisation){
        return new LocalisationDBO(localisation.getName());
    }
}
