package mappers;

import converters.FileToByteArrayConverter;
import models.NatureObservation;
import models.dbo.builders.NatureObservationDBOBuilder;
import models.dbo.NatureObservationDBO;

public class NatureObservationToNatureObservationDBOMapper {
    FileToByteArrayConverter fileToByteArrayConverter = new FileToByteArrayConverter();

    public NatureObservationDBO map(NatureObservation natureObservation){
        NatureObservationDBOBuilder dbo = new NatureObservationDBOBuilder(natureObservation.getName())
                .withDescription(natureObservation.getDescription())
                .withIdCategory(natureObservation.getCategory().getId())
                .withIdLocalisation(natureObservation.getLocalisation().getId());

        if (natureObservation.getPhoto() != null) {
            byte[] data = fileToByteArrayConverter.convert(natureObservation.getPhoto().getFile());

            dbo.withPhoto(data);
        }

        return dbo.build();
    }
}