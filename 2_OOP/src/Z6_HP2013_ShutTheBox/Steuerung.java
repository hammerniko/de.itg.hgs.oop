package Z6_HP2013_ShutTheBox;

public class Steuerung {
	
	private Gui dieGui;
	Spieler derSpieler[];
	Wuerfel derWuerfel[];
	Klappe dieKlappe[];

	private int aAugensumme;
	private int aKLappenSumme;
	private int aIdxAktiverSpieler;
	private int aMinusPunkte;

	

	public Steuerung(Gui gui,String pName1, String pName2) {
		aIdxAktiverSpieler = 0;
		aMinusPunkte = 0;
		aKLappenSumme = 0;
		aAugensumme = 0;
		
		dieGui = gui;
		
		derSpieler = new Spieler[2];
		derWuerfel = new Wuerfel[2];
		derWuerfel[0] = new Wuerfel();
		derWuerfel[1] = new Wuerfel();

		
		derSpieler[0]=new Spieler(pName1);
		derSpieler[1]=new Spieler(pName2);
		
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

		aKLappenSumme = 0;
		dieGui.aktiviereWuerfelTaste(true);

	}

	public boolean computerZug() {
		return true;
	}

	public void wuerfeln() {
		int w1 = derWuerfel[0].wuerfeln();
		int w2 = derWuerfel[1].wuerfeln();

		aAugensumme = w1+w2;
		
		System.out.println("Augensumme:"+aAugensumme);
		
		dieGui.zeichneWuerfel(w1, w2);
		dieGui.aktiviereWuerfelTaste(false);

	}

	public void klickKlappe(int klappeNr) {
		
				
		Klappe klappe = dieKlappe[klappeNr-1];

		if (klappe.gibZustand() == 0) {
					
			klappe.setzeZustand(1);
			
			// Pruefungob Summe der Augenzahlen
			// dem Wert der gewaehlten Klappe entspricht
			if (aAugensumme == klappe.gibWert()) {
				setzeKlappenEndgueltigGeschlossen();
				
			}
			else {
				aKLappenSumme = aKLappenSumme + klappe.gibWert();
				
				if(aAugensumme >= aKLappenSumme) {
					System.out.println("Klappe schliessen Summe:"+aKLappenSumme);
				}
				else if(aAugensumme == aKLappenSumme) {
					System.out.println("Klappen SchliessenSumme:"+aKLappenSumme);
				}
				else {
					System.out.println("spielerWechsel");
				}
			}
			
				
		}

	}
}
