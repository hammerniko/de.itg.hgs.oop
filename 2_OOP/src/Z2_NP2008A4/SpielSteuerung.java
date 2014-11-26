package Z2_NP2008A4;

public class SpielSteuerung {
	// Attribute
	private int zustand;
	private int xPos;
	private int yPos;

	// Assoziationen
	Benutzeroberflaeche dieBenutzeroberflaeche;
	SpielDaten dieSpielDaten;

	// Konstanten
	public static final int KEIN_FELD_GEKLICKT = 0;
	public static final int NEUE_GRUPPE = 1;
	public static final int GRUPPE_ERWEITERT = 2;
	public static final int FUENFZEHN_SIND_VOLL = 3;
	public static final int ZU_GRUPPE_ZUORDNEN = 4;

	/**
	 * Konstruktor
	 * 
	 * @param b
	 */
	public SpielSteuerung(Benutzeroberflaeche b) {
		// bidirektionale Assoziation
		dieBenutzeroberflaeche = b;
		dieBenutzeroberflaeche.linkSteuerung(this);

		// Assoziation auf Spieldaten
		dieSpielDaten = new SpielDaten();

		start();

	}

	/**
	 * Wird aufgerufen wenn das Spiel zum ersten mal gestartet wird.
	 */
	public void start() {
		setZustand(0);
		neustartClick();
	}

	/**
	 * Holt die Spielfelddaten und gibt sie auf der Oberflaeche aus.
	 */
	private void gibSpielfeldAus() {
		// hole Spielfelddaten
		int[][] sf = dieSpielDaten.getWerte();

		// sende Spielfelddaten an Oberfläche
		dieBenutzeroberflaeche.aktualisiereSpiefeld(sf);

	}

	private void erstelleNeueGruppe(int x, int y) {

		// Neue Gruppennummer holen
		int neueGrp = dieSpielDaten.gibNeueGruppe();

		// Gruppendaten speichern
		dieSpielDaten.fuegeZuGruppe(x, y, neueGrp);

		// Gruppensumme erhöhen
		dieSpielDaten.erhoeheGruppenSum(x, y, neueGrp);

		// Wert holen
		int wert = dieSpielDaten.gibWert(x, y);

		// Spielstand berechnen
		double spielstand = dieSpielDaten.berechneSpielstand();

		dieBenutzeroberflaeche.ausgebenAufFeld(x, y, wert, neueGrp);
		dieBenutzeroberflaeche.ausgebenText(1, spielstand);

	}

	private void schliesseGruppe(int x1, int y1, int x2, int y2) {

	}

	public void bearbeiteFeldClick(int x, int y) {
		
		int xNb;
		int yNb;
		int grpNrNb;
		int grpSummeNb;
		
		double spielstand;
		int wert;
		int grpNr;
		int grpSumme;
		int anzahlNachbarGruppen;
		
		grpNr = dieSpielDaten.gibGruppe(x, y);
		anzahlNachbarGruppen = dieSpielDaten.gibAnzahlNachbarn(x, y);
		
		System.out.println("anzNBGRp:"+anzahlNachbarGruppen);
		
		
		//Feld ist noch keiner Gruppe zugeordnet und nachbargruppe ist eindeutig
		if(grpNr==0 && anzahlNachbarGruppen == 1){
			
			
			//Daten der Nachbargruppe prüfen
			xNb = dieSpielDaten.gibEindeutNachbar_XPos(x, y);
			yNb = dieSpielDaten.gibEindeutNachbar_YPos(x, y);
			
			grpNrNb = dieSpielDaten.gibGruppe(xNb, yNb);
			grpSummeNb = dieSpielDaten.gibGruppenSum(grpNrNb);
			
			wert = dieSpielDaten.gibWert(x, y);
			
			if(grpSummeNb + wert < 15){
				erweitereGruppe(x, y, xNb, yNb);
			}
						
		}
		
		//Feld ist erledigt
		else if(grpNr == -1){
			return;
		}
		
		//Gruppe ist noch unvollständig
		else if(grpNr>0 && dieSpielDaten.gibGruppenSum(grpNr)<15){
			
		}

		

	}

	public void neustartClick() {
		initialisiereSpielfeld();
		dieBenutzeroberflaeche.aktualisiereSpiefeld(dieSpielDaten.getWerte());
		dieBenutzeroberflaeche.ausgebenText(0, 0);
	}

	/**
	 * Ordnet das Feld mit den Koordinaten x1,y1 der Gruppe mit den Koordinaten
	 * x2,y2 zu.
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	private void erweitereGruppe(int x1, int y1, int x2, int y2) {
		setZustand(SpielSteuerung.GRUPPE_ERWEITERT);

		int grpNr = dieSpielDaten.gibGruppe(x1, y2);
		dieSpielDaten.fuegeZuGruppe(x2, y2, grpNr);
		dieSpielDaten.erhoeheGruppenSum(x1, y1, grpNr);

		int wert = dieSpielDaten.gibWert(x1, y1);
		double spielstand = dieSpielDaten.berechneSpielstand();
		dieBenutzeroberflaeche.ausgebenAufFeld(x1, y1, wert, grpNr);
		dieBenutzeroberflaeche.ausgebenText(2, spielstand);
	}

	private void initialisiereSpielfeld() {
		dieSpielDaten.initialisiereSpielDaten();
		

	}

	private void setZustand(int zustand) {
		this.zustand = zustand;
		System.out.println("Zustand:" + zustand);
	}

}
