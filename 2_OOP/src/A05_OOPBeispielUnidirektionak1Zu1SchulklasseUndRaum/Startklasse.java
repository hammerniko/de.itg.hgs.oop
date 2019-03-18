package A05_OOPBeispielUnidirektionak1Zu1SchulklasseUndRaum;

import java.util.ArrayList;

public class Startklasse {

	public static void main(String[] args) {
		//Listen
		ArrayList<Schulklasse> dieSchulklassen = new ArrayList<Schulklasse>();
		ArrayList<Raum> dieRaeume = new ArrayList<Raum>();
		
		//Testobjekte
		Schulklasse k1 = new Schulklasse("TG 11-3");
		Raum r1 = new Raum("A307");
		
		//Objekte den Listen hinzufügen
		dieSchulklassen.add(k1);
		dieRaeume.add(r1);
		
		//Assoziation erstellen
		k1.linkKlassenzimmer(r1);
		
		//Testdaten ausgeben
		System.out.println(dieSchulklassen);
		System.out.println(dieRaeume);
		
		

	}

}
