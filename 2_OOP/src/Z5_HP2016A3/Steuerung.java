package Z5_HP2016A3;

public class Steuerung {
	
	private int anzahlMannschaften;
	private int anzahlPaarungen;
	private int zustand;
	
	//Assoziationen Steuerung
	Tabelle dieTabelle;
	Paarung diePaarung[];
	GUI dieGui;
	Mannschaft dieMannschaft[];
	
	public Steuerung() {	
		
		//Gui Objekt erzeugen und bidirektionale
		//Assoziation herstellen
		dieGui = new GUI(this);
	}
	
	public void speichereEinstellungen() {
		
		//Aus Sequenzdiagramm 2 oben Seite 2
		int regel = dieGui.gibPunkteRegel();
		
		if(regel == 2) {
			dieTabelle = new Tab_2PktRegel();
		}
		else if (regel == 3) {
			dieTabelle = new Tab_3PktRegel();
		}
		
		anzahlMannschaften = dieGui.gibAnzahlMannschaften();
		dieMannschaft = new Mannschaft[anzahlMannschaften];
		
		for (int i = 0; i <anzahlMannschaften; i++) {
			dieMannschaft[i] = new Mannschaft();
		}
		
		dieGui.sichtbarReg1_Mannschaften();
		dieGui.eintragenReg1_Index(anzahlMannschaften);
		
	}
	
	public void speichereMannschaften() {
		
	}
	
	public void zusammenfassenErgebnisse() {
		
	}
	
	public void bestimmeRangfolge() {
		
	}
	
	private void erstellePaarungObjekte() {
		
	}
	
	private void ausgebenPaarungen() {
		
	}
	
	private void einlesenSpielErgebnisse() {
		
	}
	
	private void berechneStatusMannschften() {
		
	}
	
	private void eintragenMannschafteninTabelle() {
		
	}
	
	private void ausgebenTabelle(boolean pMitRang) {
		
	}
	

	public void resetProg() {
		//Aus Sequenzidagramm 1 auf Seite 2
		dieTabelle = null;
		dieMannschaft = null;
		diePaarung = null;
		zustand = 0;
		
		dieGui.sichtbarEinstellungen();
	}
	
}
