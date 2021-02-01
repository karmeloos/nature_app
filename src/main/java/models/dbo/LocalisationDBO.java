package models.dbo;

public class LocalisationDBO {
	private int idLocalisation;
	private String Name;
	
	public int getId() {
		return idLocalisation;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name=name;
	}

	public LocalisationDBO(String name) {
		Name = name;
	}

	public LocalisationDBO(int id, String name) {
		this.idLocalisation=id;
		this.Name=name;
	}
}
