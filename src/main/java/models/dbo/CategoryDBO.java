package models.dbo;

public class CategoryDBO {
	private int idCategory;
	private String Name;
	
	public int getId() {
		return idCategory;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name=name;
	}

	public CategoryDBO(String name) {
		Name = name;
	}

	public CategoryDBO(int id, String name) {
		this.idCategory=id;
		this.Name=name;
	}
}
