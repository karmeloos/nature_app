package models.dbo.builders;

import models.dbo.NatureObservationDBO;

public class NatureObservationDBOBuilder {
    private int idObservation;
    private String name;
    private int idLocalisation;
    private int idCategory;
    private String description;
    private byte[] photo;

    public NatureObservationDBOBuilder(String name) {
        this.name = name;
    }

    public NatureObservationDBOBuilder withIdLocalisation(int idLocalisation){
        this.idLocalisation = idLocalisation;
        return this;
    }

    public NatureObservationDBOBuilder withIdCategory(int idCategory){
        this.idCategory = idCategory;
        return this;
    }
    public NatureObservationDBOBuilder withDescription(String description){
        this.description = description;
        return this;
    }
    public NatureObservationDBOBuilder withPhoto(byte[] photo){
        this.photo = photo;
        return this;
    }

    public NatureObservationDBO build(){
        return new NatureObservationDBO(idObservation, name, idLocalisation, idCategory, description, photo);
    }


}