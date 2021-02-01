package models;

public class Localisation {
    private int id;
    private String name;

    public String getName(){
        return name;
    }

    public int getId() {
        return id;
    }

    public Localisation(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Localisation(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "["+id+"] - "+name;
    }
}
