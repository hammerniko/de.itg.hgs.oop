package A01_Klassen_Uebung_Schueler;



public class ErzeugeSchueler {

	public static void main(String[] args) {
		
		//Array fuer Schuelerobjekte
		Schueler dieSchueler[] = new Schueler[3];

		//Schuelerobjekte erzeugen
		erzeugeSchueler(dieSchueler);
		
		//Objekte uendern
		
		
		
		//Objekte ausgeben
		ausgabeSchueler(dieSchueler);

}

	private static void ausgabeSchueler(Schueler[] dieSchueler) {
		// TODO Auto-generated method stub
		
	}

	private static void erzeugeSchueler(Schueler[] dieSchueler) {
		dieSchueler[0]= new Schueler("Mueller","Sven", Schueler.gruppeA);
		dieSchueler[1]= new Schueler("Maier","Michael", Schueler.gruppeA);
		dieSchueler[2]= new Schueler("Borges","Ben", Schueler.gruppeB);
	}
}