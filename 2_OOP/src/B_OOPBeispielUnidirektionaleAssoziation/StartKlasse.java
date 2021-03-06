package B_OOPBeispielUnidirektionaleAssoziation;

public class StartKlasse {
	
	public static final int ANZAHL_KLASSEN = 5;
	public static final int ANZAHLSCHUELER = 10;

  
    public static void main(String[] args) {
    	Schulklasse klassen[] 	= new Schulklasse[ANZAHL_KLASSEN];
    	Schueler 	schueler[] 	= new Schueler[ANZAHLSCHUELER];
    	    	
        //Erzeugen der Objekte
    	klassen[0] = new Schulklasse("TG11-1");
    	klassen[1] = new Schulklasse("TG11-2");
    	klassen[2] = new Schulklasse("TG11-3");
    	klassen[2].setBeschreibung("Einstiegsklasse des ITG");
    	klassen[3] = new Schulklasse("TG11-4");
    	klassen[4] = new Schulklasse("BKTK");
    	klassen[4].setBeschreibung("Berufskolleg fuer Technische Kommunikation");
    	
        schueler[0] = new Schueler("Mike","Mueller",klassen[0]);
        schueler[1] = new Schueler("Max","Bohr",klassen[0]);
        schueler[2] = new Schueler("Max","Bohr",klassen[4]);
        
        ausgabeSchueler(schueler);
        //ausgabeKlassen(klassen);
        

    }


	private static void ausgabeKlassen(Schulklasse[] klassen) {
		System.out.println("Klassen----------- ");
		for (int i = 0; i < klassen.length; i++) {
			System.out.println(klassen[i]);
		}
	}


	private static void ausgabeSchueler(Schueler[] schueler) {
		
		System.out.println("Schueler----------- ");
		for (int i = 0; i < schueler.length; i++) {
			System.out.println(schueler[i]);
		}
	}

}
