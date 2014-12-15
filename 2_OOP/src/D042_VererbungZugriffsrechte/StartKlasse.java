package D042_VererbungZugriffsrechte;



public class StartKlasse {
	
	public static void main(String[] args){
		
		//Objekt einer Unterklasse von Zeitung und Redaktuer
		//zusammengefasst in einerm Array.
		//Der Datentyp der Objekte muss der einer gemeinsamen
		//Oberklasse sein.
		Redakteur fritz = new Redakteur("Schludrie");
		Zeitung zeitungen[] = new Zeitung[2];
		zeitungen[0] = new Sonderausgabe(fritz);
		zeitungen[1] = new Wochenzeitung(fritz);
		
		//Zugriff auf Delegationsmehtode (Zeitung kennt Redaktuer)
		System.out.println(zeitungen[0].getRedakteurname());
		
		//Zugriff auf set-Methoden
		Sonderausgabe wz =  (Sonderausgabe) zeitungen[0];
		wz.setWitz("Was ist weiß und rennt bergauf? Ne Lawine mit Heimweh.");
		
		//Ausgabe einer Methode, die in allen Zeitungsklassen
		//vorhanden ist (geerbt oder überschrieben)
		for (int i = 0; i < zeitungen.length; i++) {
			zeitungen[i].test();
		}
	
		
		//Ausgabe aller Objekte komplett
		for (int i = 0; i < zeitungen.length; i++) {
			System.out.println(zeitungen[i]);
		}
		
		//Ausgabe der Anzahl der Objekte
		System.out.println(Zeitung.getAnzahlZeitungen());
		
	}
	
	
	
	

}
