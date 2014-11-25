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
	
	public void initialisiereSpielDaten(){
		
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
		return 0;
	}
}
