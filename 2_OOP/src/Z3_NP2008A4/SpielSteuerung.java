package Z3_NP2008A4;

import java.util.Vector;

public class SpielSteuerung{
	
	// Assoziationen
	Benutzeroberflaeche dieBenutzeroberflaeche;
	Vector<Gruppe> gruppen;
	Vector<Feld> freiefelder;
	

	

	public SpielSteuerung(String string, Benutzeroberflaeche b) {
		//Bidirektionale Assoziation
		dieBenutzeroberflaeche = b;
		dieBenutzeroberflaeche.linkSteuerung(this);
		
		
		gruppen = new Vector<Gruppe>();
		freiefelder = new Vector<Feld>();
	}

	

	public void bearbeiteFeldClick(int x, int y) {
		System.out.println("bearbeiteFeldklick(" +x+", "+y+")");
		
	}

	public void neustartClick() {
		//
		
	}
	
	public void erstelleNeueGruppe(Feld feld){
		gruppen.add(new Gruppe(feld));
		
	}
	
	
	public Feld[] erstelleSpielfeld(){
		return null;
	}
	
	
	

}
