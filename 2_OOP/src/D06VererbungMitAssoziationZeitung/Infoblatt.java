package D06VererbungMitAssoziationZeitung;

import java.util.ArrayList;

public class Infoblatt extends Zeitung {

	private int id;
	private static int anzahl;
	
	//Assoziation
	ArrayList<Nachricht> dieNachrichten;
	
	public Infoblatt() {
		this.titel = titel+" "+id;
		
		anzahl++;
		id=anzahl;
		
		dieNachrichten = new ArrayList<Nachricht>();
	}
	
	public void addNachricht(Nachricht n) {
		dieNachrichten.add(n);
	}

	@Override
	public String toString() {
		return "Infoblatt [id=" + id + ", dieNachrichten=" + dieNachrichten + "]";
	}

	
	
	

}
