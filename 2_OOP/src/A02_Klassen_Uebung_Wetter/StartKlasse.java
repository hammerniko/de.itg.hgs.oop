package A02_Klassen_Uebung_Wetter;

import java.util.ArrayList;

public class StartKlasse {

	public static void main(String[] args)  {
		
		//erstelle Objekte
		ArrayList<Wetterstation> wetterstationen = new ArrayList<Wetterstation>(); 
		wetterstationen.add(new Wetterstation(1,2));
		wetterstationen.add(new Wetterstation(2,3));
		wetterstationen.add(new Wetterstation(5,1));
		
		wetterstationen.remove(2);
		
		wetterstationen.add(new Wetterstation(5,1));
		wetterstationen.add(new Wetterstation(5,1));
		
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
