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
	}

	
	public void start(){
		
	}
	
	private void gibSpielfeldAus(){
		
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
	}
	
	public void ausgebenAufFeld(int x, int y, int wert, int gruppe){
		
	}
	
	public void ausgebenText(int textNr, double spielstand){
		
	}
	
	
	private void erweitereGruppe(int x1, int y1, int x2, int nbYpos) {
		// TODO Auto-generated method stub
		
	}

	
	
	

}
