package D4_Uebung_OOP_PKW;

public class Einzelteil {
	
	private String name; 
	
	public Einzelteil(String name) {
		this.name = name;
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
