package Z2_NP2008A4;

public class SpielSteuerung {
	//Assoziationen
	Benutzeroberflaeche dieBenutzeroberflaeche;
	SpielDaten dieSpielDaten;
	
	public void bearbeiteFeldClick(int x1, int y1) {
		int gruppe = dieSpielDaten.gibGruppe(x1, y1);
		int nachbarn = dieSpielDaten.gibNachbarn(x1,y1);
		int x2 = dieSpielDaten.gibEindeutNachbar_XPos(x1,y1);
		int nbYpos = dieSpielDaten.gibEindeutNachbar_YPos(x1,y1);
		
		int nbGruppe = dieSpielDaten.gibGruppe(x2, nbYpos);
		int gruppenSum = dieSpielDaten.gibGruppenSum(nbGruppe);
		int wert = dieSpielDaten.gibWert(x1,y1);
		
		erweitereGruppe(x1,y1,x2,nbYpos);
		
		
		
	}

	private void erweitereGruppe(int x1, int y1, int x2, int nbYpos) {
		// TODO Auto-generated method stub
		
	}

	
	
	

}
