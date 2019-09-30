package A02_Klassen_Uebung_Wetter;

import java.util.ArrayList;

public class StartKlasse {

	public static void main(String[] args)  {
		
		//erstelle Objekte
		Standort singen = new Standort("Singen",47.768317, 8.8336063); 
		Standort hohentwiel   = new Standort("Hohentwiel", 47.7767317,8.8360483);
		Standort hohenkraehen   = new Standort("Hohenkraehen",47.7891809,8.8285958);
		Standort maegdeberg   = new Standort("Maegdeberg",47.8058662,8.7894952);
		Standort hohenhewen   = new Standort("Hohenhewen",47.8248237,8.7691935);
		
		
		
		ArrayList<Wetterstation> wetterstationen = new ArrayList<Wetterstation>(); 
		wetterstationen.add(new Wetterstation(singen));
		wetterstationen.add(new Wetterstation(hohentwiel));
		wetterstationen.add(new Wetterstation(hohenkraehen));
		
		wetterstationen.remove(2);
		
		wetterstationen.add(new Wetterstation(maegdeberg));
		wetterstationen.add(new Wetterstation(hohenhewen));
		
		//aufräumen mit dem Garbage Collector
		System.gc();
		
		//Dem gc() etwas Zeit geben
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Wetterstationen ausgeben
		for (Wetterstation wetterstation : wetterstationen) {
			System.out.println(wetterstation);
		}
		
		System.out.println(Wetterstation.anzahlWetterstationen);

	}

}
