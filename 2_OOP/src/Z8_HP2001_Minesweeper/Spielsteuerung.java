package Z8_HP2001_Minesweeper;

public class Spielsteuerung {

	private int anzahlFreiGefunden;
	private int analyseErgebnis;
	private int dieAnzahlFelder;
	private int dieAnzahlMinen;

	// Deklaration der Assoziationen
	private SpielDaten dieSpieldaten;
	private Spieloberflaeche dieOberflaeche;

	public Spielsteuerung(Spieloberflaeche of) {

		// Assoziationen erstellen
		dieOberflaeche = of;
		dieSpieldaten = new SpielDaten();

	}

	public void initialisiereSpiel() {
		dieSpieldaten.initialisiereSpielFeldDaten();
		initialisiereMinen();
		dieOberflaeche.initialisiereSpielOberflaeche();
		
		dieOberflaeche.zeigeSpielbrett();
	}

	public void spieleZug(int xpos, int ypos) {
		
		analyseErgebnis = analysiereSpielZug(xpos, ypos);
		switch (analyseErgebnis) {
		case -1:
			dieOberflaeche.zeigeMeldung("Mine Gewaehlt");
			break;
		case -2:
			dieOberflaeche.zeigeMeldung("Feld bereits gewaehlt");
			break;
		case -3:
			dieOberflaeche.zeigeMeldung("ungaeltige Auswahl");
			break;

		default:
			//Für alle anderen Faelle ist das ergebnis
			//gleich der Anzahl der Nachbarminen
			dieSpieldaten.schreibeDatenFeld(xpos, ypos, analyseErgebnis);
			break;
		}
		
		
	}

	private int analysiereSpielZug(int xpos, int ypos) {
		int anzahlNachbarminen = 0;

		if (xpos >= 0 && xpos <= 4 && ypos >= 0 && ypos <= 4) {
			if (dieSpieldaten.leseDatenFeld(xpos, ypos) != -2) {
				if (dieSpieldaten.leseDatenFeld(xpos, ypos) != -1) {

					for (int x = xpos - 1; x <= xpos + 1; x++) {
						for (int y = ypos - 1; x <= ypos + 1; y++) {
							if (x >= 0 && x <= 4 && y >= 0 && y <= 4) {
								if (dieSpieldaten.leseDatenFeld(x, y) == -1) {
									anzahlNachbarminen++;
								}
							}
						}
						dieSpieldaten.schreibeDatenFeld(xpos, ypos, -2);
					}
				}
			}
		}

		return anzahlNachbarminen;
	}

	public void beendeSpiel() {

	}

	public int getAnzahlFreiGefunden() {
		return anzahlFreiGefunden;
	}

	public void setAnzahlFreiGefunden(int anzahlFreiGefunden) {
		this.anzahlFreiGefunden = anzahlFreiGefunden;
	}

	public int getAnalyseErgebnis() {
		return analyseErgebnis;
	}

	public void setAnalyseErgebnis(int analyseErgebnis) {
		this.analyseErgebnis = analyseErgebnis;
	}

	public int getDieAnzahlFelder() {
		return dieAnzahlFelder;
	}

	public void setDieAnzahlFelder(int dieAnzahlFelder) {
		this.dieAnzahlFelder = dieAnzahlFelder;
	}

	public int getDieAnzahlMinen() {
		return dieAnzahlMinen;
	}

	public void setDieAnzahlMinen(int dieAnzahlMinen) {
		this.dieAnzahlMinen = dieAnzahlMinen;
		dieSpieldaten.setAnzahlMinen(dieAnzahlMinen);
	}

	private void initialisiereMinen() {
		int x, y;
		int z;
		int i = 0;
		while (i < dieAnzahlMinen) {

			z = gibZufallsfeld();
			x = z / 5;
			y = z % 5;

			if (dieSpieldaten.leseDatenFeld(x, y) != -1) {
				dieSpieldaten.schreibeDatenFeld(x, y, -1);
				i++;
			}
		}
	}

	

	public int gibZufallsfeld() {
		return (int) (Math.random() * 25 + 1);
	}

}
