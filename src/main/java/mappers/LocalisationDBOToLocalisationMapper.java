package mappers;

import models.Localisation;
import models.dbo.LocalisationDBO;

public class LocalisationDBOToLocalisationMapper {
    public Localisation map(LocalisationDBO localisationdbo){
        return new Localisation(localisationdbo.getId(), localisationdbo.getName());
    }
}
