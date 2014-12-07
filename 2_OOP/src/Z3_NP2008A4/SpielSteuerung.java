package Z3_NP2008A4;

import java.util.Vector;

public class SpielSteuerung{
	
	// Assoziationen
	private Benutzeroberflaeche dieBenutzeroberflaeche;
	private Vector<Gruppe> gruppen;
	private Vector<Feld> freiefelder;
	private int zustand;
	
	

	

	public SpielSteuerung(String string, Benutzeroberflaeche b) {
		//Bidirektionale Assoziation
		dieBenutzeroberflaeche = b;
		dieBenutzeroberflaeche.linkSteuerung(this);
		
		
		gruppen = new Vector<Gruppe>();
		freiefelder = new Vector<Feld>();
		
	}

	

	public void bearbeiteFeldClick(int x, int y) {
		System.out.println("bearbeiteFeldklick(" +x+", "+y+")");
		
		switch (zustand) {
		case 0:
			
			break;

		default:
			break;
		}
		
		
		
	}

	public void neustartClick() {
		System.out.println("Neustart...");
		
		gruppen.removeAllElements();
		freiefelder.removeAllElements();
		
		for (int i = 0; i < 36; i++) {
			
		}
		
		
		
	}
	
	public void erstelleNeueGruppe(Feld feld){
		gruppen.add(new Gruppe(feld));
		freiefelder.remove(feld);
		
	}
	
	
	public void erstelleSpielfeld(Feld[] felder){
		
		
	}
	
	
	
	
	

}
