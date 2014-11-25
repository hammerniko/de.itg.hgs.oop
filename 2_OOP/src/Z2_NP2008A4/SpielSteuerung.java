package Z2_NP2008A4;

public class SpielSteuerung {
	//Attribute
	private int zustand;
	private int xPos;
	private int yPos;
	
	
	//Assoziationen
	Benutzeroberflaeche dieBenutzeroberflaeche;
	SpielDaten dieSpielDaten;
	
	/**
	 * Konstruktor
	 * @param b
	 */
	public SpielSteuerung(Benutzeroberflaeche b) {
		//bidirektionale Assoziation
		dieBenutzeroberflaeche = b;
		dieBenutzeroberflaeche.linkSteuerung(this);
		
		//Assoziation auf Spieldaten
		dieSpielDaten = new SpielDaten();
		
		start();
		
	}

	
	public void start(){
		neustartClick();
	}
	
	private void gibSpielfeldAus(){
		//hole Spielfelddaten
		int[][] sf = dieSpielDaten.getWert();
		
		//sende Spielfelddaten an Oberfläche
		dieBenutzeroberflaeche.aktualisiereSpiefeld(sf);
		
	}
	
	private void erstelleNeueGruppe(int x, int y){
		
		
	}
	
	private void schliesseGruppe(int x1, int y1, int x2, int y2){
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public void bearbeiteFeldClick(int x1, int y1) {
		
		int gruppe = dieSpielDaten.gibGruppe(x1, y1);
		int nachbarn = dieSpielDaten.gibAnzahlNachbarn(x1,y1);
		
		if(nachbarn==1){
			int x2 = dieSpielDaten.gibEindeutNachbar_XPos(x1,y1);
			int y2 = dieSpielDaten.gibEindeutNachbar_YPos(x1,y1);
			
			int nbGruppe = dieSpielDaten.gibGruppe(x2, y2);
			int gruppenSum = dieSpielDaten.gibGruppenSum(nbGruppe);
			int wert = dieSpielDaten.gibWert(x1,y1);
			
			erweitereGruppe(x1,y1,x2,y2);
			
			//...
		}
		
		
		
		
	}

	
	public void neustartClick(){
		dieSpielDaten.initialisiereSpielDaten();
		dieBenutzeroberflaeche.aktualisiereSpiefeld(dieSpielDaten.getWert());
		dieBenutzeroberflaeche.ausgebenText(0, 0);
	}
	
	
	
	
	/**
	 * Ordnet das Feld mit den Koordinaten x1,y1 der Gruppe mit den Koordinaten
	 * x2,y2 zu.
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	private void erweitereGruppe(int x1, int y1, int x2, int y2) {
		int grpNr = dieSpielDaten.gibGruppe(x1, y2);
		dieSpielDaten.fuegeZuGruppe(x2,y2,grpNr);
		dieSpielDaten.erhoeheGruppenSum(x1,y1,grpNr);
		
		int wert = dieSpielDaten.gibWert(x1, y1);
		double spielstand = dieSpielDaten.berechneSpielstand();
		dieBenutzeroberflaeche.ausgebenAufFeld(x1,y1,wert,grpNr);
		dieBenutzeroberflaeche.ausgebenText(2, spielstand);
	}

	
	
	

}
