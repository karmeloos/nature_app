package database;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import models.dbo.CategoryDBO;
import models.dbo.LocalisationDBO;
import models.dbo.NatureObservationDBO;

public class Database implements IDatabase {
	public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:observations.db";
    
    private Connection conn;
    private Statement stat;

    public Database() {
        try {
            Class.forName(Database.DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("No JDBC driver");
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("Problem with opening connection");
            e.printStackTrace();
        }

        createTables();
    }

    public boolean createTables()  {
        String createObservations = "CREATE TABLE IF NOT EXISTS NatureObservations (idObservation INTEGER PRIMARY KEY AUTOINCREMENT, Name varchar(255),idLocalisation int,idCategory int,Description varchar(255),Photo MEDIUMBLOB)";
        String createLocalisations = "CREATE TABLE IF NOT EXISTS Localisations (idLocalisation INTEGER PRIMARY KEY AUTOINCREMENT, Name varchar(255))";
        String createCategories = "CREATE TABLE IF NOT EXISTS Categories (idCategory INTEGER PRIMARY KEY AUTOINCREMENT, Name varchar(255))";
        try {
            stat.execute(createObservations);
            stat.execute(createLocalisations);
            stat.execute(createCategories);
        } catch (SQLException e) {
            System.err.println("Error while creating tables");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    @Override
    public boolean insertObservation(NatureObservationDBO dbo) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into NatureObservations values (NULL, ?, ?, ?, ?, ?);");
            prepStmt.setString(1, dbo.getName());
            prepStmt.setInt(2, dbo.getIdLocalisation());
            prepStmt.setInt(3, dbo.getIdCategory());
            prepStmt.setString(4, dbo.getDescription());
            prepStmt.setBytes(5, dbo.getPhoto());
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Error inserting Observation");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean insertLocalisation(LocalisationDBO locDBO) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into Localisations values (NULL, ?);");
            prepStmt.setString(1, locDBO.getName());
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Error inserting into Localisations");
            return false;
        }
        return true;
    }

    @Override
    public boolean insertCategory(CategoryDBO catDBO) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into Categories values (NULL, ?);");
            prepStmt.setString(1, catDBO.getName());
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Error inserting into Categories");
            return false;
        }
        return true;
    }

    @Override
    public List<NatureObservationDBO> selectAllObservations() {
        List<NatureObservationDBO> observations = new LinkedList<NatureObservationDBO>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM NatureObservations");
            int id;
            String Name, Description;
            byte[] Photo;
            int idLocalisation, idCategory;
            while(result.next()) {
                id = result.getInt("idObservation");
                Name = result.getString("Name");
                idLocalisation = result.getInt("idLocalisation");
                idCategory = result.getInt("idCategory");
                Description = result.getString("Description");
                Photo = result.getBytes("Photo");
                observations.add(new NatureObservationDBO(id, Name, idLocalisation, idCategory, Description, Photo));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return observations;
    }

    @Override
    public List<LocalisationDBO> selectLocalisations() {
        List<LocalisationDBO> localisations = new LinkedList<LocalisationDBO>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM Localisations");
            int id;
            String Name;
            while(result.next()) {
                id = result.getInt("idLocalisation");
                Name = result.getString("Name");
                localisations.add(new LocalisationDBO(id, Name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return localisations;
    }

    @Override
    public List<CategoryDBO> selectCategories() {
        List<CategoryDBO> categories = new LinkedList<CategoryDBO>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM Categories");
            int id;
            String Name;
            while(result.next()) {
                id = result.getInt("idCategory");
                Name = result.getString("Name");
                categories.add(new CategoryDBO(id, Name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return categories;
    }

    public CategoryDBO selectCategory(int id) {
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM Categories WHERE idCategory = " + id + ";");

            if (result.next()) {
                int idCat = result.getInt("idCategory");
                String Name = result.getString("Name");
                return new CategoryDBO(idCat, Name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public LocalisationDBO selectLocalisation(int id) {
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM Localisations WHERE idLocalisation = " + id + ";");

            if (result.next()) {
                int idLoc = result.getInt("idLocalisation");
                String Name = result.getString("Name");
                return new LocalisationDBO(idLoc, Name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Error closing connection");
            e.printStackTrace();
        }
    }
}
