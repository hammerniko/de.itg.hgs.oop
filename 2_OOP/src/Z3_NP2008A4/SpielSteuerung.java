package Z3_NP2008A4;

import java.util.Vector;

public class SpielSteuerung{
	
	// Assoziationen
	private Benutzeroberflaeche dieBenutzeroberflaeche;
	private Vector<Gruppe> gruppen;
	private Vector<Feld> freiefelder;	
	private Feld[] spielfeld;
	private int zustand;
	
	

	

	public SpielSteuerung(String string, Benutzeroberflaeche b) {
		//Bidirektionale Assoziation
		dieBenutzeroberflaeche = b;
		dieBenutzeroberflaeche.linkSteuerung(this);
		
		spielfeld = new Feld[36];
		gruppen = new Vector<Gruppe>();
		freiefelder = new Vector<Feld>();
		
	}

	

	public void bearbeiteFeldClick(int x, int y) {
		System.out.println("bearbeiteFeldklick(" +x+", "+y+")");
		
		
		
		
	}

	public void neustartClick() {
		System.out.println("Neustart...");
		
	
		dieBenutzeroberflaeche.aktualisiereSpiefeld(erstelleSpielfeld());
		
		
		
		
		
	}
	
	public void erstelleNeueGruppe(Feld feld){
		
		gruppen.add(new Gruppe(feld));
		freiefelder.remove(feld);
		
	}
	
	
	private Feld[] erstelleSpielfeld(){
		
		
		
		gruppen.removeAllElements();
		freiefelder.removeAllElements();
		int N = 6;
		int x,y;
		
		for (int i = 0; i < N*N; i++) {
			 x = i / N;
	         y = i % N;
	         
			spielfeld[i]=new Feld(x, y);
			freiefelder.add(spielfeld[i]);
		}
		
		
		
		return spielfeld;
		
	}
	
	
	
	
	

}
