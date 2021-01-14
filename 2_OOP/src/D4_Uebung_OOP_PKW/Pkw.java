package D4_Uebung_OOP_PKW;

import java.util.Arrays;

public class Pkw {
	
	Einzelteil[] dieEinzelteile;
	
	public Pkw() {
		dieEinzelteile = new Einzelteil[100];
	}
	
	
	public void addEinzelteil(Einzelteil teil) {
		for (int i = 0; i < dieEinzelteile.length; i++) {
			if(dieEinzelteile[i]==null) {
				dieEinzelteile[i]=teil;
				return;
			}
		}	
				System.err.println("Teil konnte nicht eingefuegt werden");
			
		
		
	}
	
	public Einzelteil getEinzelteil(String bezeichnungTeil) {
		Einzelteil teil=null;
		
		for (int i = 0; i < dieEinzelteile.length; i++) {
			if(bezeichnungTeil.equals(dieEinzelteile[i].getName())) {
				teil = dieEinzelteile[i];
			}
		}
		
		return teil;
		
	}


	@Override
	public String toString() {
		return "Pkw [dieEinzelteile=" + Arrays.toString(dieEinzelteile) + "]";
	}
	
	

}
