package Z7_HP2012_A4;

public class Start_A41 {

	public static void main(String[] args) {
		Verein fc = new Verein();
		
		fc.addMitglied(new Spieler("Mario"));
		fc.addMitglied(new Trainer("Horst"));
		fc.addMitglied(new Person("Hans"));
		fc.addMitglied(new Spieler("Lucas"));
		fc.addMitglied(new Mitarbeiter("Sepp"));
		
		fc.alleVorstellen();
		
		

	}

}
