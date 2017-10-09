package B_OOPBeispielUnidirektionaleAssoziation1;

public class Schueler {
	
	//Eigene Attribute
	private String name;
	private String vorname;
	
	//Assoziation
	Schulklasse dieSchulklasse;

	public Schueler(String name, String vorname, Schulklasse dieSchulklasse) {
		super();
		this.name = name;
		this.vorname = vorname;
		this.dieSchulklasse = dieSchulklasse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getSchulklasse() {
		return dieSchulklasse.getKuerzelStdPlan();
	}
	
	
	public void ausgabeText(String pText) {
		System.out.println(pText);
	}

	
	
}
