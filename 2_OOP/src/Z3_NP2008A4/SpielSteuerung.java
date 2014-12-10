package Z3_NP2008A4;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class SpielSteuerung{
	
	// Assoziationen
	private Benutzeroberflaeche dieBenutzeroberflaeche;
	
	private List<Gruppe> gruppen;
	private List<Feld> freiefelder;	
	private Feld[] spielfeld;
	
	private int zustand;
	
	public SpielSteuerung(String string, Benutzeroberflaeche b) {
		//Bidirektionale Assoziation
		dieBenutzeroberflaeche = b;
		dieBenutzeroberflaeche.linkSteuerung(this);
		
		spielfeld = new Feld[36];
		gruppen = new ArrayList<Gruppe>();
		freiefelder = new ArrayList<Feld>();
		
		neustartClick();
	}

	

	public void bearbeiteFeldClick(Feld feld) {
		System.out.println("bearbeiteFeldklick(" +feld);
		
		//Wenn auf ein freies Feld geklickt wurde
		if(freiefelder.contains(feld)){
			
			//Wenn das Feld genau einen Nachbar hat
			
			freiefelder.remove(feld);
			gruppen.add(new Gruppe(feld));
			aktualisiereFeld(feld);
			
			
			//Wenn das Feld mehr als eine Nachbargruppe hat
			
			
			
			
			
			
		}
		
		
		
		dieBenutzeroberflaeche.aktualisiereSpiefeld(spielfeld);
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
		
		gruppen.clear();
		freiefelder.clear();
		int N = 6;
		int x,y;
		
		for (int i = 0; i < N*N; i++) {
			 x = i / N;
	         y = i % N;
	         
	        Feld feld = new Feld(x,y);
			spielfeld[i]=feld;
			freiefelder.add(feld);
		}
		
		return spielfeld;
		
	}
	
	private void aktualisiereFeld(Feld feld){
		dieBenutzeroberflaeche.aktualisiereFeld(feld);
	}
	
	
	
	
	

}
