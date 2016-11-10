package D01a_VererbungUeberschreibenBeispiel;

public abstract class Mitarbeiter {
	private String name;
	private String vorname;

	public Mitarbeiter(String name, String vorname){
		this.name = name;
		this.vorname = vorname;
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

	public abstract double berechneGehalt();

}
