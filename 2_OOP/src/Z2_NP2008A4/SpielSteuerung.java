package Z2_NP2008A4;

public class SpielSteuerung implements Runnable{
	// Attribute
	private int zustand;
	private int xPos;
	private int yPos;
	private int x2;
	private int y2;
	private Thread t;

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
	public SpielSteuerung(String name, Benutzeroberflaeche b) {
		// bidirektionale Assoziation
		dieBenutzeroberflaeche = b;
		dieBenutzeroberflaeche.linkSteuerung(this);

		// Assoziation auf Spieldaten
		dieSpielDaten = new SpielDaten();
		
		//Spielsteuerung als ZUstandsautomat
		new Thread(this, name).start();

		

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
		setZustand(NEUE_GRUPPE);

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
		dieSpielDaten.schliesseGruppe(x1, y1, x2, y2);
		dieBenutzeroberflaeche.ausgebenAufFeld(x1, y1,
				dieSpielDaten.gibWert(x1, y1), dieSpielDaten.gibGruppe(x1, y1));

	}

	public void bearbeiteFeldClick(int x, int y) {
		xPos = x;
		yPos = y;
		int grpNr = dieSpielDaten.gibGruppe(x, y);
		int anzahlNachbarGruppen = dieSpielDaten.gibAnzahlNachbarn(x, y);

		System.out.println("anzNBGRp:" + anzahlNachbarGruppen);

	

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

	@Override
	public void run() {
	boolean work = true;	
	while (work) {
			System.out.println("Steuerung runs...");
			try {
				switch (zustand) {
				case KEIN_FELD_GEKLICKT:
					dieBenutzeroberflaeche.ausgebenText(0, dieSpielDaten.berechneSpielstand());
				    dieBenutzeroberflaeche.waitFor();
					
					break;

				case NEUE_GRUPPE:
					erstelleNeueGruppe(xPos, yPos);
					dieBenutzeroberflaeche.ausgebenText(1, dieSpielDaten.berechneSpielstand());
					dieBenutzeroberflaeche.waitFor();
					break;

				case GRUPPE_ERWEITERT:
					erweitereGruppe(xPos, yPos, x2, y2);
					dieBenutzeroberflaeche.waitFor();
					break;

				case FUENFZEHN_SIND_VOLL:

					dieBenutzeroberflaeche.waitFor();
					break;

				case ZU_GRUPPE_ZUORDNEN:

					dieBenutzeroberflaeche.waitFor();
					break;

				default:
					break;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	

}
