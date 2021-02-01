package facades;

import database.IDatabase;

import java.util.List;

public abstract class Facade<T> {
    protected IDatabase database;

    public Facade(IDatabase database) {
        this.database = database;
    }
    public abstract void add(T obj);
    public abstract List<T> getAll();
}

