package A04_OOPErweiterungMit1zuN;

public class Schulart {
	
	private String name;
	private String info;
	
	public Schulart(String name) {
		this.name = name;
	}

	//getter und setter
	public String getName() {
		return name;
	}

	public String getInfo() {
		return info;
	}

	@Override
	public String toString() {
		return "Schulart [name=" + name + ", info=" + info + "]";
	} 

	
	
	
	
	
}
