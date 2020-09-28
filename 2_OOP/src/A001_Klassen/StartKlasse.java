package A001_Klassen;

public class StartKlasse {

	public static void main(String[] args) {
		
		//Erzeuge Schueler mit Standard Konstruktor
		Schueler max = new Schueler("Mueller","Max");
		Schueler gerd = new Schueler("G","kasjfk");
		
		
		System.out.println(max.toString());
		System.out.println(gerd.toString());
		
		
		
		
		
		
		
		
		
		gerd = null; //objekt gerd löschen
		
		//garbage collector
		System.gc();
		
		//zeit gewinnen
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
		System.out.println(Schueler.anzErzeugterSchueler);
	}

}
