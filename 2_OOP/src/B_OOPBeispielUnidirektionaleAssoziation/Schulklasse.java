package B_OOPBeispielUnidirektionaleAssoziation;

public class Schulklasse {
	
	String klasse;

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
		return "Schulklasse [klasse=" + klasse + "]";
	}
	
	

}
