package models;

public class Category {
    private int id;
    private String name;

    public String getName(){
        return name;
    }

    public int getId() {
        return id;
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "["+id+"] - "+name;
    }
}
