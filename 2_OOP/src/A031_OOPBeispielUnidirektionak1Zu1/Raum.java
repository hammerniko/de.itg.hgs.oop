package A031_OOPBeispielUnidirektionak1Zu1;

public class Raum {
	
	private int anzahlPlaetze;
	private String raumnummer;
	
	
	private Gebaeude dasGebaeude;

	public Raum(int anzahlPlaetze, String raumnummer, Gebaeude dasGebaeude) {
		super();
		this.anzahlPlaetze = anzahlPlaetze;
		this.raumnummer = raumnummer;
		this.dasGebaeude = dasGebaeude;
	}

	public int getAnzahlPlaetze() {
		return anzahlPlaetze;
	}

	public void setAnzahlPlaetze(int anzahlPlaetze) {
		this.anzahlPlaetze = anzahlPlaetze;
	}

	public String getRaumnummer() {
		return raumnummer;
	}

	public void setRaumnummer(String raumnummer) {
		this.raumnummer = raumnummer;
	}

	public Gebaeude getDasGebaeude() {
		return dasGebaeude;
	}

	

	@Override
	public String toString() {
		return "Raum [anzahlPlaetze=" + anzahlPlaetze + ", raumnummer=" + raumnummer + ", dasGebaeude=" + dasGebaeude
				+ "]";
	}
	
	
	

}
