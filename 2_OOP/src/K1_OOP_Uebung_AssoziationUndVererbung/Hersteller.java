package K1_OOP_Uebung_AssoziationUndVererbung;

import java.net.URI;
import java.util.ArrayList;

public class Hersteller {
	
	private String name;
	private URI url;
	private ArrayList<Bauteil> dieHerstellerTeile;
	
	public Hersteller(String name) {
		super();
		dieHerstellerTeile = new ArrayList<Bauteil>();
		this.name = name;
	}

	public void addBauteil(Bauteil bauteil) {
		dieHerstellerTeile.add(bauteil);
		
	}
	
	public void removeBautiel(Bauteil bauteil) {
		dieHerstellerTeile.remove(bauteil);
		
	}
	
	public Bauteil getBauteil(int bauteilNr) {
		for (int i = 0; i < dieHerstellerTeile.size(); i++) {
			if(dieHerstellerTeile.get(i).getBauteilNr()==bauteilNr) {
				return dieHerstellerTeile.get(bauteilNr);
			}
		}
		
		return null;
	}

	@Override
	public String toString() {
		return name;
	}
	
	

}
