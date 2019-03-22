package D05_VererbungBeispielFastFood;

public class StartKlasse {

	public static void main(String[] args) {
		//1. Schichtführer und 1 Kuechenmitarbeiter erstellen
		Schichtfuehrer s1 = new Schichtfuehrer("Peter", "Hans");
		KuechenMitarbeiter k1 = new KuechenMitarbeiter("Bolika", "Anna");
		Reinigungskraft r1 = new Reinigungskraft("Macht", "Sauber");
		KuechenMitarbeiter k2 = new KuechenMitarbeiter("Bolika", "Berta");
		DriveInMitarbeiter d1 = new DriveInMitarbeiter("Speck", "Casrten");
		MacCoffeeMitarbeiter m1 = new MacCoffeeMitarbeiter("Berg", "Ben");
	
		//2. Überstunden setzen
		k1.setUeberstunden(3);
		k2.setStundenlohn(9);
		s1.setStundenlohn(12.5);
		
		
		//3. Alle Mitarbieter in einem Array speichern
		Mitarbeiter[] dieMitarbeiter = new Mitarbeiter[6];
		dieMitarbeiter[0] = s1;
		dieMitarbeiter[1] = k1;
		dieMitarbeiter[2] = r1;
		dieMitarbeiter[3] = k2;
		dieMitarbeiter[4] = d1;
		dieMitarbeiter[5] = m1;
		
		//4. Berechne das Gehalt aller Mitarbeiter und gib es aus
		for (int i = 0; i < dieMitarbeiter.length; i++) {
			System.out.println(dieMitarbeiter[i]);
		}
		

	}

}
