package A002_Uebung_Klassen_Projekttage;

public class Startklasse {

	public static void main(String[] args) {
		//Person erstellt
		Person betreuer1 = new 	Person("Held", "Tom");
		
		//Projekt erstellen
		Projekt windsurfen = new Projekt("Windsurfen", betreuer1);
	}
	
}
