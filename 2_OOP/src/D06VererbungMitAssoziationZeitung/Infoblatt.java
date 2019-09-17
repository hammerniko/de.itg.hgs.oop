package D06VererbungMitAssoziationZeitung;

import java.util.ArrayList;

public class Infoblatt extends Zeitung {

	private int id;
	private static int anzahl=0;
	
	//Assoziation
	ArrayList<Nachricht> dieNachrichten;
	
	public Infoblatt() {
		this.titel = titel;
		anzahl++;
		id=anzahl;
		
		dieNachrichten = new ArrayList<Nachricht>();
		Nachricht.setAnzahl(0);
	}
	
	public void addNachricht(Nachricht n) {
		dieNachrichten.add(n);
	}

	@Override
	public String toString() {
		return titel +" "+id+""+dieNachrichten;
	}

	
	
	

}
