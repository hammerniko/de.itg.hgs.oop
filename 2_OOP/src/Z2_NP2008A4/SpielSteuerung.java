package Z2_NP2008A4;

public class SpielSteuerung {
	// Attribute
	private int zustand;
	private int xPos;
	private int yPos;

	// Assoziationen
	Benutzeroberflaeche dieBenutzeroberflaeche;
	SpielDaten dieSpielDaten;

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
		//Neue Gruppennummer holen
		int neueGrp = dieSpielDaten.gibNeueGruppe();
		
		//Gruppendaten speichern
		dieSpielDaten.fuegeZuGruppe(x, y, neueGrp);
		
		//Gruppensumme erhöhen
		dieSpielDaten.erhoeheGruppenSum(x, y, neueGrp);
		
		//Wert holen
		int wert = dieSpielDaten.gibWert(x, y);
		
		//Spielstand berechnen
		double spielstand = dieSpielDaten.berechneSpielstand();
		
		dieBenutzeroberflaeche.ausgebenAufFeld(x, y, wert, neueGrp);
		dieBenutzeroberflaeche.ausgebenText(1, spielstand);

	}

	private void schliesseGruppe(int x1, int y1, int x2, int y2) {

	}

	public void bearbeiteFeldClick(int x1, int y1) {

		int gruppe = dieSpielDaten.gibGruppe(x1, y1);

		// Feld ist erledigt
		if (gruppe == -1) {

		}

		// feld ist noch frei
		else if (gruppe == 0) {

			int nachbarn = dieSpielDaten.gibAnzahlNachbarn(x1, y1);

			// Wenn Anzahl unvollständiger Nachbargruppen ==
			if (nachbarn == 1) {
				int x2 = dieSpielDaten.gibEindeutNachbar_XPos(x1, y1);
				int y2 = dieSpielDaten.gibEindeutNachbar_YPos(x1, y1);

				int nbGruppe = dieSpielDaten.gibGruppe(x2, y2);
				int gruppenSum = dieSpielDaten.gibGruppenSum(nbGruppe);
				int wert = dieSpielDaten.gibWert(x1, y1);

				erweitereGruppe(x1, y1, x2, y2);

				// ...
			}

			// Feld ist frei und es gibt keine Nachbarn
			else if (nachbarn == 0) {
				zustand = 1;
				erstelleNeueGruppe(x1, y1);
				
			}

			// Feld ist frei und es gibt mehr als eine unvollständige
			// Nachbargruppe. Nachbargruppe nicht eindeutig
			else if (nachbarn == 2) {
				zustand = 5;
				dieBenutzeroberflaeche.ausgebenText(4, dieSpielDaten.berechneSpielstand());
			}
		}
		
		//Gruppenummer bei unvollständiger Gruppe
		else{
			
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
		int grpNr = dieSpielDaten.gibGruppe(x1, y2);
		dieSpielDaten.fuegeZuGruppe(x2, y2, grpNr);
		dieSpielDaten.erhoeheGruppenSum(x1, y1, grpNr);

		int wert = dieSpielDaten.gibWert(x1, y1);
		double spielstand = dieSpielDaten.berechneSpielstand();
		dieBenutzeroberflaeche.ausgebenAufFeld(x1, y1, wert, grpNr);
		dieBenutzeroberflaeche.ausgebenText(2, spielstand);
	}
	
	private void initialisiereSpielfeld(){
		dieSpielDaten.initialisiereSpielDaten();
		
	}

}
