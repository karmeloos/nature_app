package facades;

import database.IDatabase;
import mappers.NatureObservationDBOToNatureObservationMapper;
import mappers.NatureObservationToNatureObservationDBOMapper;
import models.*;
import models.dbo.NatureObservationDBO;

import java.util.List;
import java.util.stream.Collectors;

public class NatureObservationFacade extends Facade<NatureObservation>
{
    NatureObservationToNatureObservationDBOMapper natureObservationToNatureObservationDBOMapper = new NatureObservationToNatureObservationDBOMapper();

    NatureObservationDBOToNatureObservationMapper mapper = new NatureObservationDBOToNatureObservationMapper();
    public NatureObservationFacade(IDatabase database) {
        super(database);
    }

    @Override
    public void add(NatureObservation obj) {
        NatureObservationDBO dbo = natureObservationToNatureObservationDBOMapper.map(obj);

        database.insertObservation(dbo);
    }

    @Override
    public List<NatureObservation> getAll() {
        List <NatureObservationDBO> observationsDBOs = database.selectAllObservations();
        return observationsDBOs.stream().map(s -> mapper.map(s, database)).collect(Collectors.toList());
    }
}
