package Z5_HP2016A3_Ismail_Nikolai;

public class Mannschaft {

	private String name;
	private int anzahlToreErzielt;
	private int anzahlToreBekommen;
	private int anzahlSiege;
	private int anzahlUnentscheiden;
	private int anzahlNiederlagen;
	private int punkte;

	public Mannschaft() {
		setzeAttributeAufNull();
	}

	public void eintragenName(String pName) {
		name = pName;
	}

	public void addiereToreErzielt(int pAnzahl) {
		anzahlToreErzielt += pAnzahl;
	}

	public void addiereToreBekommen(int pAnzahl) {
		anzahlToreBekommen += pAnzahl;
	}

	public void erhoeheAnzahlSiege() {
		anzahlSiege++;
	}

	public void erhoeheAnzahlNiederlagen() {
		anzahlNiederlagen++;
	}

	public void erhoeheAnzahlUnentschieden() {
		anzahlUnentscheiden++;
	}

	public void addierePunkte(int pPunkte) {
		punkte += pPunkte;
	}

	public int berechneAnzahlSpiele() {

		int spiele = anzahlNiederlagen + anzahlSiege + anzahlUnentscheiden;
		return spiele;
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

	public int gibAnzahlUnentscheiden() {
		return anzahlUnentscheiden;
	}

	public int gibAnzahlNiederlagen() {
		return anzahlNiederlagen;
	}

	public int gibPunkte() {
		return punkte;
	}

	private void setzeAttributeAufNull() {

		name = null;
		anzahlToreErzielt = 0;
		anzahlToreBekommen = 0;
		anzahlSiege = 0;
		anzahlUnentscheiden = 0;
		anzahlNiederlagen = 0;
		punkte = 0;
	}

}
