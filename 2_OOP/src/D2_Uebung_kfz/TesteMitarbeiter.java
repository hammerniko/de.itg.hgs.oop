package D2_Uebung_kfz;

public class TesteMitarbeiter {

	public static void main(String[] args) {
		 
		 //Array für alle Mitarbeiter
		 Mitarbeiter[] dieMitarbeiter = new Mitarbeiter[5];
		 
		 //Mitarbeiterobjekte erstellen und Daten setzen
		 Sekretaerin moni = new Sekretaerin("Meier","Moni",15,30,152);
		 KfzMechaniker dirk = new KfzMechaniker("Dirty", "Dirk", 20, 40);
		 dirk.setUeberStundenAmWochenende(90);
		 dirk.setUeberstunden(60);
		
		 //Mitarbeiterobjekte in Array speichern
		 dieMitarbeiter[0] = moni;
		 dieMitarbeiter[1] = dirk;
		 
		 
		 /*		Schleife zur Ausgabe der Daten aller Mitarbeiter
		  * 	Die toString() Methode wird implizit aufgerufen, wenn
		  *     ein Objekt einer print-Anweisung übergeben wird. 
		  */
		 for (int i = 0; i < 5; i++) {
			System.out.println(dieMitarbeiter[i]);
		}
		 
		 
		 
	}

}
