package A01_Klassen_�bung_Sch�ler;



public class ErzeugeSchueler {

	public static void main(String[] args) {
		
		//Array f�r Sch�lerobjekte
		Schueler dieSchueler[] = new Schueler[3];

		//Sch�lerobjekte erzeugen
		erzeugeSchueler(dieSchueler);
		
		//Objekte �ndern
		
		
		
		//Objekte ausgeben
		ausgabeSchueler(dieSchueler);

}

	private static void erzeugeSchueler(Schueler[] dieSchueler) {
		dieSchueler[0]= new Schueler("M�ller","Sven", Schueler.gruppeA);
		dieSchueler[1]= new Schueler("Maier","Michael", Schueler.gruppeA);
		dieSchueler[2]= new Schueler("Borges","Ben", Schueler.gruppeB);
	}
}