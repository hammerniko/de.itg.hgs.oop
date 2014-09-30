package A01_Klassen_Uebung_Schueler;

public class ErzeugeSchueler {

	public static void main(String[] args) {

		//Array fuer Schuelerobjekte
		Schueler dieSchueler[] = new Schueler[4];

		//Schuelerobjekte erzeugen
		erzeugeSchueler(dieSchueler);

		//Objekte ausgeben
		ausgabeSchueler(dieSchueler);
		
		//Objekte uendern
		aendereSchueler(dieSchueler);

		//geänderte Objekte ausgeben
		ausgabeSchueler(dieSchueler);
		
		

	}

	private static void aendereSchueler(Schueler[] dieSchueler) {
		dieSchueler[1].setGruppe(Schueler.gruppeB);
		Schueler.setKlassensprecher(dieSchueler[1]);
		Schueler.setStvKlassensprecher(dieSchueler[0]);
		dieSchueler[3]=null;
		aktualisiereStatus();
		
		
		
	}

	private static void aktualisiereStatus() {
		//Garbage Collector aufrufen
		System.gc();
		
		//kurz warten, damit löschen (finalize Methode) registriert wird
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void erzeugeSchueler(Schueler[] dieSchueler) {
		dieSchueler[0] = new Schueler("Mueller", "Sven", Schueler.gruppeA);
		dieSchueler[1] = new Schueler("Maier", "Michael", Schueler.gruppeA);
		dieSchueler[2] = new Schueler("Borges", "Benni", Schueler.gruppeB);
		dieSchueler[3] = new Schueler("Dür", "Detlef", Schueler.gruppeB);
	}
	
	private static void ausgabeSchueler(Schueler[] dieSchueler) {
		for (int i = 0; i < dieSchueler.length; i++) {
			System.out.println(dieSchueler[i]);
		}
		
		
		//Ausgabe Klassensprecher
		System.out.println("Klassensprecher:\t"+Schueler.getKlassensprecher());
		System.out.println("Stv. Klassensprecher:\t"+Schueler.getStvKlassensprecher());
		System.out.println("-------------------------------------------------");
		
		//Ausgabe Anzahl Schüler
		System.out.println("Anzahl:"+Schueler.getAnzahlSchueler());

	}
}