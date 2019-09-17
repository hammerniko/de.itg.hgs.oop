package D05_VererbungBeispielFastFood;

public class Mitarbeiter {
	
	//Variablen
	private String name;
	private String vorname;
	private double stundenlohn;
	private double ueberstundensatz;
	private double ueberstunden;
	
	//Konstanten
	public static final double STUNDEN_PRO_WOCHE = 38.5;

	//Konstruktor
	public Mitarbeiter(String name, String vorname) {
		super();
		this.name = name;
		this.vorname = vorname;
		
		stundenlohn = 8.5;
		ueberstundensatz = 10;
		ueberstunden = 0;
	}

	//Getter und Setter
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

	public double getStundenlohn() {
		return stundenlohn;
	}

	public void setStundenlohn(double stundenlohn) {
		this.stundenlohn = stundenlohn;
	}

	public double getUeberstundensatz() {
		return ueberstundensatz;
	}

	public void setUeberstundensatz(double ueberstundensatz) {
		this.ueberstundensatz = ueberstundensatz;
	}
	
	public double berechneGehalt() {
		double gehalt = 4*STUNDEN_PRO_WOCHE * stundenlohn+ueberstunden*ueberstundensatz;
		return gehalt;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "\t"+ name + " " + vorname + ", stundenlohn=" + stundenlohn
				+ ", ueberstundensatz=" + ueberstundensatz + ", ueberstunden=" + ueberstunden + ", Gehalt="
				+ berechneGehalt();
	}
	
	public double getUeberstunden() {
		return ueberstunden;
	}

	public void setUeberstunden(double ueberstunden) {
		this.ueberstunden = ueberstunden;
	}
	
	
	
	
	
	
	

}
