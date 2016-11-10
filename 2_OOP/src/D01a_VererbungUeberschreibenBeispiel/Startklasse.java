package D01a_VererbungUeberschreibenBeispiel;

public class Startklasse {

	Mitarbeiter derMitarbeiter;

	public static void main(String[] args) {
		
		Mitarbeiter dieMA[] = new Mitarbeiter[4];
		dieMA[0] = new Angestellter("Max","Meier");
		dieMA[1] = new Hausmeister("Stefan","Raab");
		dieMA[2] = new Lehrer("Hammer","Niko");
		dieMA[3] = new Vertrauenslehrer("Kopp","Tobias");

		for (int i = 0; i < 4; i++) {
			
			System.out.print(dieMA[i].getClass().getSimpleName());
			System.out.print(" "+dieMA[i].getName());
			System.out.print(" "+dieMA[i].getVorname());
			System.out.println(" "+dieMA[i].berechneGehalt());
		}

	}

	
	
	
}
