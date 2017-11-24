package Z5_HP2016A3_Ismail_Nikolai;

public class Steuerung {

	private static final int MIN_ANZAHL_MANNSCHAFTEN = 3;
	public static final int MAX_ANZAHL_MANNSCHAFTEN = 10;
	GUI dieGUI;
	Tabelle dieTabelle;
	Mannschaft dieMannschaft[];
	Paarung diePaarung[];

	private int anzahlMannschaften;
	private int anzahlPaarungen;
	private int zustand;
	private boolean mitRang = false;

	public Steuerung() {
		dieGUI = new GUI(this);
	}

	public void speichereEinstellungen() {

		if (dieGUI.gibPunkteRegel() == 2) {
			dieTabelle = new Tab_2PktRegel();
		} else {
			dieTabelle = new Tab_3PktRegel();
		}

		anzahlMannschaften = dieGUI.gibAnzahlMannschaften();

		if (anzahlMannschaften > MAX_ANZAHL_MANNSCHAFTEN || anzahlMannschaften < MIN_ANZAHL_MANNSCHAFTEN) {
			dieGUI.showInputError("Anzahl Mannschaften falsch!");
			return;
		}

		dieMannschaft = new Mannschaft[anzahlMannschaften];

		for (int i = 0; i < anzahlMannschaften; i++) {
			dieMannschaft[i] = new Mannschaft();
		}

		dieGUI.sichtbarReg1_Mannschaften();
	}

	public void speichereMannschaften() {

		for (int i = 0; i < anzahlMannschaften; i++) {

			String name = dieGUI.gibNameMannschaft(i);
			dieMannschaft[i].eintragenName(name);
		}

		erstellePaarungObjekte();
		dieGUI.sichtbarReg2_Ergebnisse();
		ausgebenPaarungen();
	}

	public void zusammenfassenErgebnisse() {

		berechneStatusMannschaften();

		for (int i = 0; i < dieMannschaft.length; i++) {
			dieTabelle.berechnePunkte(dieMannschaft[i]);
		}

		dieGUI.sichtbarReg3_Tabelle();
		eintragenMannschaftenInTabelle();

	}

	public void bestimmeRangfolge() {

		mitRang = true;
		dieGUI.card4.btRangfolge.setEnabled(false);
		dieMannschaft = sort(dieMannschaft);
		ausgebenTabelle(mitRang);

	}

	private Mannschaft[] sort(Mannschaft[] dieMannschaft2) {

		boolean unsortiert = true;
		Mannschaft tmp;

		while (unsortiert) {
			unsortiert = false;
			for (int i = 0; i < dieMannschaft2.length - 1; i++)
				if (dieMannschaft2[i].gibPunkte() < dieMannschaft2[i + 1].gibPunkte()) {

					tmp = dieMannschaft2[i];
					dieMannschaft2[i] = dieMannschaft2[i + 1];
					dieMannschaft2[i + 1] = tmp;
					unsortiert = true;
				}
		}

		return dieMannschaft2;
	}

	public void resetProg() {

		mitRang = false;
		dieMannschaft = null;
		dieTabelle = null;
		diePaarung = null;
		zustand = 0;

		dieGUI.sichtbarEinstellung();
	}

	private void erstellePaarungObjekte() {

		diePaarung = new Paarung[(anzahlMannschaften * (anzahlMannschaften - 1)) / 2];
		int i = 0;

		for (int j = 0; j < anzahlMannschaften - 1; j++) {
			for (int k = j + 1; k < anzahlMannschaften; k++) {
				diePaarung[i] = new Paarung(j, k);
				i += 1;
			}
		}

		anzahlPaarungen = i;
	}

	private void ausgebenPaarungen() {

		for (int i = 0; i < anzahlPaarungen; i++) {

			int index_M1 = diePaarung[i].gibIndex_Mx(1);
			int index_M2 = diePaarung[i].gibIndex_Mx(2);

			String Name1 = dieMannschaft[index_M1].gibName();
			String Name2 = dieMannschaft[index_M2].gibName();

			dieGUI.anzeigenPaarung(i, Name1, Name2);
		}
	}

	private void berechneStatusMannschaften() {

		for (int i = 0; i < anzahlPaarungen; i++) {

			int ToreM1 = diePaarung[i].gibTore_Mx(1);
			int ToreM2 = diePaarung[i].gibTore_Mx(2);

			int M1 = diePaarung[i].gibIndex_Mx(1);
			int M2 = diePaarung[i].gibIndex_Mx(2);

			if (ToreM1 > ToreM2) {// T1>T2
				// T1
				dieMannschaft[M1].erhoeheAnzahlSiege();
				dieMannschaft[M1].addiereToreErzielt(ToreM1);
				dieMannschaft[M1].addiereToreBekommen(ToreM2);
				// T2
				dieMannschaft[M2].erhoeheAnzahlNiederlagen();
				dieMannschaft[M2].addiereToreErzielt(ToreM2);
				dieMannschaft[M2].addiereToreBekommen(ToreM1);

			} else if (ToreM1 == ToreM2) {
				// Unentschieden
				dieMannschaft[M1].erhoeheAnzahlUnentschieden();
				dieMannschaft[M2].erhoeheAnzahlUnentschieden();
				// ToreErzielt
				dieMannschaft[M1].addiereToreErzielt(ToreM1);
				dieMannschaft[M2].addiereToreErzielt(ToreM2);
				// ToreBekommen
				dieMannschaft[M1].addiereToreBekommen(ToreM2);
				dieMannschaft[M2].addiereToreBekommen(ToreM1);
			} else { // T1<T2

				dieMannschaft[M1].erhoeheAnzahlNiederlagen();
				dieMannschaft[M1].addiereToreErzielt(ToreM1);
				dieMannschaft[M1].addiereToreBekommen(ToreM2);

				dieMannschaft[M2].erhoeheAnzahlSiege();
				dieMannschaft[M2].addiereToreErzielt(ToreM2);
				dieMannschaft[M2].addiereToreBekommen(ToreM1);
			}
		}
	}

	private void eintragenMannschaftenInTabelle() {

		for (int i = 0; i < dieMannschaft.length; i++) {

			int rang = 0;

			if (mitRang) {
				rang = i + 1;
			}

			String mannschaft = dieMannschaft[i].gibName();
			int spiele = (dieMannschaft[i].berechneAnzahlSpiele());
			int punkte = dieMannschaft[i].gibPunkte();
			int torePlus = dieMannschaft[i].gibAnzahlToreErzielt();
			int toreMinus = dieMannschaft[i].gibAnzahlToreBekommen();

			dieGUI.anzeigenInTab(i, rang, mannschaft, spiele, punkte, torePlus, toreMinus);
		}
	}

	private void ausgebenTabelle(boolean pMitRang) {

		if (pMitRang) {
			eintragenMannschaftenInTabelle();
		}
	}

	public Mannschaft[] getDieMannschaft() {
		return dieMannschaft;
	}

	public Paarung[] getDiePaarung() {
		return diePaarung;
	}

	public int getAnzahlPaarungen() {
		return anzahlPaarungen;
	}
}
