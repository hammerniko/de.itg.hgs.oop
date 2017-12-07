package Z6_HP2013_ShutTheBox;

public class Steuerung {

	Spieler derSpieler[];
	Wuerfel derWuerfel[];
	Klappe dieKlappe[];

	private int aAugensumme;
	private int aKLappenSumme;
	private int aIdxAktiverSpieler;
	private int aMinusPunkte;

	private Gui dieGui;

	public Steuerung(Gui gui) {
		aIdxAktiverSpieler = 0;
		aMinusPunkte = 0;
		aKLappenSumme = 0;
		aAugensumme = 0;
		dieGui = gui;
		derSpieler = new Spieler[2];
		derWuerfel = new Wuerfel[2];
		derWuerfel[0] = new Wuerfel();
		derWuerfel[1] = new Wuerfel();

		dieKlappe = new Klappe[9];

		for (int i = 0; i < dieKlappe.length; i++) {
			dieKlappe[i] = new Klappe(i + 1);
		}
	}

	public void wechsleSpieler() {
		int zustand;
		
		for (int i = 0; i < dieKlappe.length; i++) {
			zustand = dieKlappe[i].gibZustand();
			if(zustand!=2) {
				aMinusPunkte = aMinusPunkte+dieKlappe[i].gibWert();
				dieKlappe[i].setzeZustand(0);
				
			}
		}
		
		aMinusPunkte = aMinusPunkte + derSpieler[aIdxAktiverSpieler].gibMinusPunkte();
		derSpieler[aIdxAktiverSpieler].setzeMinusPunkte(aMinusPunkte);
		dieGui.zeigePunkte(aIdxAktiverSpieler, aMinusPunkte);
		aIdxAktiverSpieler = gibIdxNaechsterSpieler();
		aMinusPunkte = derSpieler[aIdxAktiverSpieler].gibMinusPunkte();
		dieGui.oeffneAlleKlappen();
		dieGui.aktiviereWechselTaste(false);
		dieGui.aktiviereWechselTaste(true);

	}

	private int gibIdxNaechsterSpieler() {
		
		if(aIdxAktiverSpieler == 0) {
			aIdxAktiverSpieler = 1;
		}
		else {
			aIdxAktiverSpieler = 0;
		}
		
		return aIdxAktiverSpieler;
	}

	private void setzeKlappenEndgueltigGeschlossen() {
		int zustand;
		for (int idxKlappe = 0; idxKlappe < dieKlappe.length; idxKlappe++) {
			zustand = dieKlappe[idxKlappe].gibZustand();

			if (zustand == 1) {
				dieKlappe[idxKlappe].setzeZustand(2);
				dieGui.schliesseKlappe(idxKlappe + 1);
			}
		}

		dieGui.aktiviereWuerfelTaste(true);

	}

	public boolean computerZug() {
		return true;
	}

	public void wuerfeln() {
		int w1 = derWuerfel[0].wuerfeln();
		int w2 = derWuerfel[1].wuerfeln();

		dieGui.zeichneWuerfel(w1, w2);

		dieGui.aktiviereWuerfelTaste(false);

	}

	public void klickKlappe(int klappeNr) {

		if (dieKlappe[klappeNr - 1].gibZustand() == 0) {
			dieKlappe[klappeNr - 1].setzeZustand(1);
			int wert = dieKlappe[klappeNr - 1].gibWert();

			// Prüfungob Summe der Augenzahlen
			// dem Wert der gewählten Klappe entspricht
			if (dieGui.gibAugensumme() == wert) {
				setzeKlappenEndgueltigGeschlossen();
			}
		}

	}
}
