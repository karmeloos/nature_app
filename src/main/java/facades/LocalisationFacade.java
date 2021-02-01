package facades;

import database.IDatabase;
import mappers.LocalisationDBOToLocalisationMapper;
import mappers.LocalisationToLocalisationDBOMapper;
import models.Localisation;
import models.dbo.LocalisationDBO;

import java.util.List;
import java.util.stream.Collectors;

public class LocalisationFacade extends Facade<Localisation> {
    LocalisationDBOToLocalisationMapper localisationDBOToLocalisationMapper = new LocalisationDBOToLocalisationMapper();
    LocalisationToLocalisationDBOMapper localisationToLocalisationDBOMapper = new LocalisationToLocalisationDBOMapper();

    public LocalisationFacade(IDatabase database) {
        super(database);
    }

    @Override
    public void add(Localisation obj) {
        LocalisationDBO dbo = localisationToLocalisationDBOMapper.map(obj);

        database.insertLocalisation(dbo);
    }

    @Override
    public List<Localisation> getAll() {
        List <LocalisationDBO> localisationDBOS = database.selectLocalisations();
        return localisationDBOS.stream().map(s -> localisationDBOToLocalisationMapper.map(s)).collect(Collectors.toList());
    }

}
