package D01a_VererbungUeberschreibenBeispiel;

public class Startklasse {

	Mitarbeiter derMitarbeiter;

	public static void main(String[] args) {
		Mitarbeiter dieMA[] = new Mitarbeiter[10];
		dieMA[0] = new Angestellter();
		dieMA[1] = new Hausmeister();
		dieMA[2] = new Lehrer();
		dieMA[3] = new Vertrauenslehrer();

		for (int i = 0; i < 4; i++) {
			System.out.println(dieMA[i].berechneGehalt());
		}

	}

}
