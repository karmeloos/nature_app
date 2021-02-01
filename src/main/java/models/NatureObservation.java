package models;

import helpers.ImageAdapter;

public class NatureObservation {
    private int id;
    private String name;
    private Category category;
    private Localisation localisation;
    private String description;
    private ImageAdapter Photo;

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public Localisation getLocalisation() {
        return localisation;
    }

    public ImageAdapter getPhoto() {
        return Photo;
    }

    public int getId() {
        return id;
    }

    public NatureObservation(int id, String name, Category category, Localisation localisation, String description, ImageAdapter photo) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.localisation = localisation;
        this.description = description;
        this.Photo = photo;
    }

    public NatureObservation(String name, Category category, Localisation localisation, String description, ImageAdapter photo) {
        this.name = name;
        this.category = category;
        this.localisation = localisation;
        this.description = description;
        this.Photo = photo;
    }

    @Override
    public String toString() {
        return "["+id+"] - "+name+" - "+localisation.getName()+" - "+category.getName()+" - "+description+" - "+Photo;
    }
}
