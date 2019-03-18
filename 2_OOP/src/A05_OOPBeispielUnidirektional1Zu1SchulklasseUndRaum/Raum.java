package A05_OOPBeispielUnidirektional1Zu1SchulklasseUndRaum;

public class Raum {
	
	private int anzahlPlaetze;
	private String raumNummer;
	
	
	//Konstanten
	public static final int SITZPLAETZE_STANDARD_ZIMMER = 30;
	
	public Raum(String raumNummer) {
		super();
		this.raumNummer = raumNummer;
		anzahlPlaetze = SITZPLAETZE_STANDARD_ZIMMER;
	}

	public int getAnzahlPlaetze() {
		return anzahlPlaetze;
	}

	public void setAnzahlPlaetze(int anzahlPlaetze) {
		this.anzahlPlaetze = anzahlPlaetze;
	}

	public String getRaumNummer() {
		return raumNummer;
	}

	public void setRaumNummer(String raumNummer) {
		this.raumNummer = raumNummer;
	}

	@Override
	public String toString() {
		return "Raum [anzahlPlaetze=" + anzahlPlaetze + ", raumNummer=" + raumNummer + "]";
	}
	
	
	

}
