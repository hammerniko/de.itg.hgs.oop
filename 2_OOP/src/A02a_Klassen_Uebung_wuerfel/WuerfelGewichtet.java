package A02a_Klassen_Uebung_wuerfel;

public class WuerfelGewichtet extends Wuerfel {

	/**
	 * //Wahscheinlichkeiten der Ziffern 1-6 von 0 - 100(%) als int die Summe
	 * der Wahrscheinlichkeiten muss 100 ergeben
	 */
	int g1, g2, g3, g4, g5, g6;

	public WuerfelGewichtet(int g1, int g2, int g3, int g4, int g5, int g6)
			throws WuerfelFalschGewichtetException {

		if (g1 + g2 + g3 + g4 + g5 + g6 != 100) {
			// generiere Fehlermeldung
			throw new WuerfelFalschGewichtetException();
		}
		this.g1 = g1;
		this.g2 = g1 + g2;
		this.g3 = g1 + g2 + g3;
		this.g4 = g1 + g2 + g4 + g3;
		this.g5 = g1 + g2 + g3 + g4 + g5;

	}

	@Override
	public int gibWuerfelzahl() {
		int wuerfelZahl = 0;

		// erzeuge Zufallszahl von 0..100
		int z = (int) (Math.random() * 100);

		if (z > g5) {
			wuerfelZahl = 6;

		} else if (z > g4) {
			wuerfelZahl = 5;
		} else if (z > g3) {
			wuerfelZahl = 4;
		} else if (z > g2) {
			wuerfelZahl = 3;
		} else if (z > g1) {
			wuerfelZahl = 2;
		} else {
			wuerfelZahl = 1;
		}

		return wuerfelZahl;
	}

}
