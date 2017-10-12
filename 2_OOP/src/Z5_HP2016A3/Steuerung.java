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
			dieGui.trace("Tabelle 2PkteRegel erstellt");
		}
		else if (regel == 3) {
			dieTabelle = new Tab_3PktRegel();
			dieGui.trace("Tabelle 3PkteRegel erstellt");
		}
		
		anzahlMannschaften = dieGui.gibAnzahlMannschaften();
		
		if(anzahlMannschaften >6 || anzahlMannschaften < 3) {
			dieGui.showInputError("Anzahl Mannschaften falsch");
			return;
		}
		
		dieMannschaft = new Mannschaft[anzahlMannschaften];
		
		for (int i = 0; i <anzahlMannschaften; i++) {
			dieMannschaft[i] = new Mannschaft();
		}
		
		dieGui.trace("Mannschaften erstellt");
		
		dieGui.sichtbarReg1_Mannschaften();
		dieGui.eintragenReg1_Index(anzahlMannschaften);
		
		
	}
	
	public void speichereMannschaften() {
		
	}
	
	public void zusammenfassenErgebnisse() {
		
	}
	
	public void bestimmeRangfolge() {
		
	}
	
	public void erstellePaarungObjekte() {
		
		//Algorithmus aus Aufgabe 3.2
		diePaarung = new Paarung[15];
		anzahlMannschaften = 4; //Test für Aufgabe 3.2a
		int i = 0;
		for (int j = 0; j <= anzahlMannschaften-2; j++) {
			for (int k = j+1; k <= anzahlMannschaften-1; k++) {
				diePaarung[i]=new Paarung(j, k);
				i++;
			}
		}
		anzahlPaarungen = i;
		
		//Test für Aufgabe 3.2a
		System.out.println(i);
		
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
