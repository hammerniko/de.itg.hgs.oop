package Z5_HP2016A3;

public class Mannschaft {
	private String name;
	private int anzahlToreErzielt;
	private int anzahlToreBekommen;
	private int anzahlSiege;
	private int anzahlUnentschieden;
	private int anzahlNiederlagen;
	private int punkte;
	
	//Konstruktor
	public Mannschaft() {
		setzeAttributeAufNull();
	}
	
	private void setzeAttributeAufNull() {
		// TODO Auto-generated method stub
		name = null;
		anzahlNiederlagen = 0;
		anzahlToreErzielt = 0;
		anzahlSiege = 0;
		anzahlUnentschieden = 0;
		punkte = 0;
	}

	public void eintragenName(String pName) {
		name = pName;
	}
	
	public void addiereToreErzeilt(int pAnzahl) {
		anzahlToreErzielt = anzahlToreErzielt + pAnzahl;
	}
	
	public void addiereToreBekommen(int pAnzahl) {
		anzahlToreBekommen = anzahlToreBekommen + pAnzahl;
	}
	
	public void erhoeheAnzahlSiege() {
		anzahlSiege++;
	}
	
	public void erhoerheAnzahlUnentschieden() {
		anzahlUnentschieden++;
	}

	public void erhoheAnzahlNiederlagen() {
		anzahlNiederlagen++;
	}
	
	public void addierePunkte(int pPunkte) {
		punkte = punkte + pPunkte;
	}
	
	public String gibName() {
		return name;
	}
	
	public int gibAnzahlToreErzielt() {
		return anzahlToreErzielt;
	}
	
	public int gibAnzahlToreBekommen() {
		return anzahlToreBekommen;
	}
	
	public int gibAnzahlSiege() {
		return anzahlSiege;
	}
	
	public int gibAnzahlUnentschieden() {
		return anzahlUnentschieden;
	}
	
	public int gibAnzahlNiederlagen() {
		return anzahlNiederlagen;
	}
	
	public int gibPunkte() {
		return punkte;
	}
	
	public int berechneAnzahlSpiele() {
		return 0;
	}
	
	
	
}
