package Z5_HP2016A3;

public class GUI {

	// Attribut für Assoziation zur Steuerung
	Steuerung dieSteuerung;

	// Konstruktor
	public GUI(Steuerung pSteuerung) {
		super();
		dieSteuerung = pSteuerung;
	}

	public void clickInit() {
		//aus Sequenzdiagramm 1 oben Seite 2
		dieSteuerung.resetProg();
	
	}

	public void clickSpeichernEinstellungen() {
		//aus Sequenzdiagramm 2 oben Seite 2
		dieSteuerung.speichereEinstellungen();
		
		
		

	}

	public void clickSpeichernManschaften() {

	}

	public void clickErmittelnPaarungen() {

	}

	public void clickZusammenfassenErgebnis() {

	}

	public void clickBestimmeRangfolge() {

	}

	public void clickBeenden() {

	}

	public String gibNameMannschaft(int pZeile) {
		// ermittle Name der Mannschaft

		return "Mannschaftsname...";
	}

	public int gibErgebnisPaarung(int pZeile, int Mannschaft) {
		// ermittle Ergebnis
		return 0;
	}

	public void anzeigenPaarung(int pZeile, String pM1, String pM2) {

	}

	public void anzeigenInTab(int pZeile, int pRang, String pMannschaft, int pSpiele, int pPunkte, int pTorePlus,
			int pToreMinus) {

	}

	public void sichtbarEinstellungen() {

	}

	public void sichtbarReg1_Mannschaften() {

	}

	public void sichtbarReg2_Ergebnisse() {

	}

	public void sichtbarReg3_Tabelle() {

	}

	public int gibPunkteRegel() {
		
		int regel = 0;
		// Regel ermitteln und zurückgeben 
		
		
		return regel;
	}

	public int gibAnzahlMannschaften() {
		int anzahlManschften = 0;
		//anzahl Mannschaften ermitteln
		//und zurückgeben
		return anzahlManschften;
	}

	public void eintragenReg1_Index(int anzahlMannschaften) {
		// TODO Auto-generated method stub
		
	}

	

}
