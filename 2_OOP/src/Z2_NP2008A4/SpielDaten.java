package Z2_NP2008A4;

import java.util.Vector;

public class SpielDaten {
	
	//Attribute
	private int[][] wert;
	private int[][] gruppe;
	private Vector<Integer> gruppenSum;
	
	
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
				wert[x][y] = (int) (Math.random()*9+1);
				gruppe[x][y]=0;
			}
			
		}
		
		gruppenSum.removeAllElements();
	}

	public int[][] getWert() {
		return wert;
	}

	public int gibNeueGruppe(){
		return 0;
	}
	
	public void gibGruppeFrei(int gruppe){
		
	}
	
	public int gibGruppe(int x, int y){
		return 0;
	}

	public int gibNachbarn(int x, int y) {
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
		return 0;
	}

	public int gibWert(int x, int y) {
		// TODO Auto-generated method stub
		return wert[x][y];
	}
}
