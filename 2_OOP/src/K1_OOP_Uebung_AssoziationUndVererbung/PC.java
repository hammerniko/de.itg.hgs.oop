package K1_OOP_Uebung_AssoziationUndVererbung;

import java.util.ArrayList;

public class PC {
	
	private static int anzahlPCsErzeugt = 0;
	private ArrayList<Bauteil> dieBauteile;
	private int pcNr;
	
	
	
	
	public PC() {
		super();
		dieBauteile = new ArrayList<Bauteil>();
		anzahlPCsErzeugt++;
		pcNr = anzahlPCsErzeugt;
	}

	public void addBautiel(Bauteil bauteil) {
		dieBauteile.add(bauteil);
		
	}
	
	public void removeBautiel(Bauteil bauteil) {
		dieBauteile.remove(bauteil);
		
	}
	
	public Bauteil getBauteil(int bauteilNr) {
		for (int i = 0; i < dieBauteile.size(); i++) {
			if(dieBauteile.get(i).getBauteilNr()==bauteilNr) {
				return dieBauteile.get(bauteilNr);
			}
		}
		
		return null;
	}

	public int getPcNr() {
		return pcNr;
	}

	@Override
	public String toString() {
		return "PC:"+pcNr + "\n" + dieBauteile ;
	}
	
	
}
