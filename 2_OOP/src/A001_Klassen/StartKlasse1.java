package A001_Klassen;

public class StartKlasse1 {

	public static void main(String[] args) {
		
		Schueler1[] dieSuS = new Schueler1[3];
		
		//Objekt erstellen mit dem Standardkonstruktor
		dieSuS[0] = new Schueler1("Binder","Justin");
		dieSuS[1] = new Schueler1("Sohst","Detleff");
		dieSuS[2] = new Schueler1("Dick", "Moby");
		
		
		
		//Daten ändern
		dieSuS[1].setVorname("Maximilian");
		
		
		
		
		
		//Testausgabe
		for (int i = 0; i < dieSuS.length; i++) {
			System.out.println(dieSuS[i]);
		}
		
		
		
	}

}
