package A04_OOPErweiterungMit1zuN;

public class Lehrer {
	
	private String name;
	private String kuerzel;
	
	//Konstruktor
	public Lehrer(String name, String kuerzel) {
		this.name = name;
		this.kuerzel = kuerzel;
	}

	public String getName() {
		return name;
	}

	public String getKuerzel() {
		return kuerzel;
	}

	@Override
	public String toString() {
		return "Lehrer [name=" + name + ", kuerzel=" + kuerzel + "]";
	}

	
	
}
