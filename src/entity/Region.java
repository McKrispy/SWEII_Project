package entity;

public class Region {
    private int id;
    private String name;
    private String code;
    
    //constructor
	public Region(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}

	@Override
	public String toString() {
		return "Region [id=" + id + ", name=" + name + ", code=" + code + "]";
	}


}    