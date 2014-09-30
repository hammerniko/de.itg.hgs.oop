package A01_Klassen_Übung_Schüler;



public class ErzeugeSchueler {

	public static void main(String[] args) {
		
		//Array für Schülerobjekte
		Schueler dieSchueler[] = new Schueler[3];

		//Schülerobjekte erzeugen
		erzeugeSchueler(dieSchueler);
		
		//Objekte ändern
		
		
		
		//Objekte ausgeben
		ausgabeSchueler(dieSchueler);

}

	private static void erzeugeSchueler(Schueler[] dieSchueler) {
		dieSchueler[0]= new Schueler("Müller","Sven", Schueler.gruppeA);
		dieSchueler[1]= new Schueler("Maier","Michael", Schueler.gruppeA);
		dieSchueler[2]= new Schueler("Borges","Ben", Schueler.gruppeB);
	}
}