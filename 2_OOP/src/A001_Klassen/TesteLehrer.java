package A001_Klassen;

public class TesteLehrer {

	public static void main(String[] args) {
		
		//Array für Lehrer
		Lehrer[] dieLehrer = new Lehrer[2];
		
		
		
		//2 Lehrerobjekte erstellen und testen
		dieLehrer[0] = new Lehrer("Hammer","Nikolai");
		dieLehrer[1] = new Lehrer("Kopp","Tobias",new char[] {'k','t'});
		
		
		
		
		
		
		
		
		
		
		//Ausgabe
		for (int i = 0; i < dieLehrer.length; i++) {
			System.out.println(dieLehrer[i]);
		}

	}

}
