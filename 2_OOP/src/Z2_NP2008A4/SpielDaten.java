package Z2_NP2008A4;

import java.util.Vector;

public class SpielDaten {
	
	//Attribute
	private int gruppennummer=0;
	private int[][] wert=null;
	private int[][] gruppe=null;
	private Vector<Integer> gruppenSum=null;
	
	
	public SpielDaten(){
		wert = new int[6][6];
		gruppe = new int[6][6];
		gruppenSum = new Vector<Integer>();
		
	}
	
	/**
	 * alle werte werden mit einer Zufallszahl initialisiert
	 * alle Gruppen werden gelöscht
	 * alle Gruppensummen werden gelöscht
	 */
	public void initialisiereSpielDaten(){
		for (int y = 0; y < wert.length; y++) {
			for (int x = 0; x < wert.length; x++) {
				
				//Erzeuge eine Zufallszahl zwischen 1 und 9
				wert[x][y] = (int) (Math.random()*9+1);
				
				//Lösche alle gruppen
				gruppe[x][y]=0;
			}
			
		}
		
		//Initialisiere die Gruppennummer
		gruppennummer = 0;
		
		//Lösche alle Gruppensumme
		gruppenSum.removeAllElements();
	}

	public int[][] getWert() {
		return wert;
	}

	
	
	/**
	 * Erstellt eine neue Gruppennummer
	 * und gibt sie zurück.
	 */
	public int gibNeueGruppe(){
		gruppennummer++;
		return gruppennummer;
	}
	
	/**
	 * Durchsucht alle Gruppenfelder nach der freizugebenden
	 * Gruppe und setzt sie zurück
	 * @param gruppenr
	 */
	public void gibGruppeFrei(int gruppenr){
		for (int y = 0; y < gruppe.length; y++) {
			for (int x = 0; x < gruppe.length; x++) {
				if(gruppe[x][y]==gruppenr){
					gruppe[x][y]=0;
					
				}
			}
			
		}
	}
	
	/**
	 * Ergebnis = -1 --> Feld erledigt
	 * Ergebnis = 0  --> Feld frei
	 * Ergebnis > 0  --> Gruppennummer bei unvollständiger Gruppe
	 * @param x
	 * @param y
	 * @return
	 */
	public int gibGruppe(int x, int y){
		return gruppe[x][y];
	}

	/**
	 * Prüfz Anzahl unvollständiger Nachbargruppen
	 * Ergebnis 0 -> keine
	 * Ergebnis 1 -> eine
	 * Ergebnis 2 -> mehr als eine
	 * @param x
	 * @param y
	 * @return
	 */
	public int gibAnzahlNachbarn(int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int gibEindeutNachbar_XPos(int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int gibEindeutNachbar_YPos(int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int gibGruppenSum(int nbGruppe) {
		// TODO Auto-generated method stub
		return gruppenSum.elementAt(nbGruppe);
	}

	public int gibWert(int x, int y) {
		// TODO Auto-generated method stub
		return wert[x][y];
	}
}
