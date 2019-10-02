package A02a_Klassen_Uebung_wuerfel;

public class Spieler {

	String name;

	// Array für die Assoziation deklarieren
	Wuerfel dieWuerfel[];

	public Spieler(String name) {
		this.name = name;

		// Spieler hat 3 Wuerfel
		// Array für die Wuerfelobjekte erstellen
		dieWuerfel = new Wuerfel[3];

		// Wuerfelobjekte in das Array packen
		dieWuerfel[0] = new Wuerfel();
		dieWuerfel[1] = new Wuerfel();
		dieWuerfel[2] = new Wuerfel();
	}

	// Evtl. mit Rückgabewert, wenn GUI-Ausgabe erwünscht ist
	public void wuerfeln() {
		for (int i = 0; i < dieWuerfel.length; i++) {
			System.out.print(dieWuerfel[i].gibWuerfelzahl()+" / ");
		}

	}
	
	

}
