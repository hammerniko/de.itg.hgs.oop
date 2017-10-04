package Z5_HP2016A3;

public abstract class Tabelle {
	protected int anzahlZeilen;
	
	Mannschaft[] inTabZeile;
	
	public Tabelle() {
				
		inTabZeile = new Mannschaft[anzahlZeilen];
	}
	
	public abstract void berechnePunkte(int pAnzMannschaften);
	
	public void hinzufuegenMannschaften(Mannschaft pMannschaft) {
		
	}
	
	public void sortierenTabelle() {
		
	}
	
	public Mannschaft gibMannschaftInZeile(int pZeile) {
		return null;
	}
	
	

}
