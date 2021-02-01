package models.dbo;

public class NatureObservationDBO {
	private int idObservation;
	private String Name;
	private int idLocalisation;
	private int idCategory;
	private String Description;
	private byte[] Photo;

	public int getId() {
		return idObservation;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name=name;
	}
	
	public int getIdLocalisation() {
		return idLocalisation;
	}
	public int getIdCategory() {
		return idCategory;
	}
	public String getDescription() {
		return Description;
	}
	public byte[] getPhoto() {
		return Photo;
	}

	public NatureObservationDBO(int id, String name, int idLocalisation, int idCategory, String Description, byte[] Photo) {
		this.idObservation=id;
		this.Name=name;
		this.idLocalisation=idLocalisation;
		this.idCategory=idCategory;
		this.Description=Description;
		this.Photo=Photo;
	}
}
