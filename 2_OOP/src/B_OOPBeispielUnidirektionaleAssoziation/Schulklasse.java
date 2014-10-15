package B_OOPBeispielUnidirektionaleAssoziation;

public class Schulklasse {
	
	String klasse;
	String beschreibung;

	public Schulklasse(String klasse) {
		super();
		this.klasse = klasse;
	}

	public String getKlasse() {
		return klasse;
	}

	public void setKlasse(String klasse) {
		this.klasse = klasse;
	}

	@Override
	public String toString() {
		return klasse + "\t" + beschreibung;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	
	
	

}
