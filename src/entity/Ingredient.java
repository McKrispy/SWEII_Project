package entity;

public class Ingredient {
	 private int id;
	 private String name;
	 
	// constructors
	public Ingredient(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		}
	
	

	public Ingredient(String name) {
		super();
		this.name = name;
	}


	//getters&setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
