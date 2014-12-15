package D042_VererbungZugriffsrechte;



public class StartKlasse {
	
	public static void main(String[] args){
		
		//Objekt einer Unterklasse von Zeitung und Redaktuer
		Redakteur fritz = new Redakteur("Schludrie");
		Sonderausgabe sa = new Sonderausgabe(fritz);
		Wochenzeitung wz = new Wochenzeitung(fritz);
		
		//Zugriff auf Delegationsmehtode (Zeitung kennt Redaktuer)
		System.out.println(sa.getRedakteurname());
		
		//Zugriff auf set-Methoden
		sa.setWitz("Was ist weiß und rennt bergauf? Ne Lawine mit Heimweh.");
		wz.setSchlagzeile("Frauenquote ist beschlossene Sache!");
		
		//Zugriff auf geerbte Methoden
		sa.test();
		sa.id = 1;
		//sa.redakteuNr geht nicht, da nur erbende Klassen ZUgriff haben
		System.out.println(wz.getSchlagzeile());
		
		
		//Ausgabe über toString (alle Klassen müssen toString implementieren)
		System.out.println(sa);
		System.out.println(wz);
	}
	
	
	
	

}
