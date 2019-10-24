package Z8_HP2001_Minesweeper;

import javax.swing.JFrame;

public class Spieloberflaeche extends JFrame {

	private int[][] spielBrett;
	
	// Deklaration der Assoziation
	Spielsteuerung dieSteuerung;

	public Spieloberflaeche(Spielsteuerung s) {
		// Bidirektionale Assoziation zur Steuerung
		s = new Spielsteuerung(this);
		spielBrett = new int[SpielDaten.ANZAHL_FELDER][SpielDaten.ANZAHL_FELDER];
	}

	public void zeigeMeldung(String meldung) {
		System.out.println(meldung);

	}

	public void mausClickAufFeldXY() {
		int x = 2;
		int y = 1;

		dieSteuerung.spieleZug(x, y);

	}

	public void neuesSpiel() {
		setAnzahlMinen();
		dieSteuerung.initialisiereSpiel();

	}

	private void setAnzahlMinen() {
		int anzalMinen = 5; // wird über neues Spiel eingestellt
		dieSteuerung.setDieAnzahlMinen(anzalMinen);
	}

	public void initialisiereSpielOberflaeche() {
		// TODO Auto-generated method stub

	}

	public void zeigeSpielbrett() {
		for (int x = 0; x < SpielDaten.ANZAHL_FELDER; x++) {
			for (int y = 0; y < SpielDaten.ANZAHL_FELDER; y++) {
				System.out.println();
			}
		}
	}

}
