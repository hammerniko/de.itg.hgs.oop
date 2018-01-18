package I02_Zustandsdiagramm_Geldautomat;

import java.util.Scanner;

public class Geldautomat implements Runnable {

	private int zustand;
	private Thread thread;
	private boolean istKarteGueltig;
	private boolean istPinGueltig;
	private boolean karteErkannt;
	private boolean bestaetigenGedrueckt;
	private Karte karte;

	public static final int AUS = 0;
	public static final int START = 1;
	public static final int KARTEN_PRUEFUNG = 2;
	public static final int PIN_EINGABE = 3;
	private static final int AUSZAHLEN = 4;
	private static final int UEBERWEISEN = 5;

	public Geldautomat() {
		karte = null;
		karteErkannt = false;
		istKarteGueltig = false;
		istPinGueltig = false;
		bestaetigenGedrueckt = false;
		zustand = START; // Anfagszustand
		thread = new Thread(this); // Automat ist nebenläufig
	}

	@Override
	public void run() {

		// Lebenszyklus des Geldautomaten
		while (zustand != AUS) {

			switch (zustand) {
			case START:
				while (!karteErkannt) {
					warte();
					warte();
					// Für Beispielszenario karte wird nach einem wartezyklus erkannt
					karteErkannt = true;
					karte = new Karte(1234, true);
				}
				zustand = KARTEN_PRUEFUNG;
				break;

			case KARTEN_PRUEFUNG:
				if (pruefeKarte(karte)) {
					istKarteGueltig = true;

					System.out.println("Karte gültig");
					zustand = PIN_EINGABE;
				} else {
					istKarteGueltig = false;
					karteAuswerfen();
				}
				break;

			case PIN_EINGABE:
				pinEingabe();

				break;

			case AUSZAHLEN:
				auszahlen();
				break;

			case UEBERWEISEN:
				ueberweisen();
				break;
			}

		}

	}

	private void pinEingabe() {
		Scanner s = new Scanner(System.in);
		String strPin = "";
		int pinZiffer;
		int anzZiffern = 0;
		int pin;
		int anzahlVersuche = 0;

		System.out.print("Pin:");
		do {
			try {

				pinZiffer = s.nextInt();
				strPin = strPin + pinZiffer;
				System.out.print(strPin);
				anzZiffern++;

				if (strPin.length() == 4) {
					pin = Integer.parseInt(strPin);
					prüfePin(pin);
					anzahlVersuche++;
					anzZiffern = 0;
					strPin = "";
				}

			} catch (Exception e) {
				System.out.println("Bitte nur Ziffern eingeben");
			}

		} while (!istPinGueltig && anzahlVersuche < 3);

		if (istPinGueltig) {
			zeigeAuswahl();
		} else {
			zustand = START;
			karteAuswerfen();
		}

		s.close();
		s = null;
	}

	private void prüfePin(int pin) {

		if (pin == karte.getPin()) {
			istPinGueltig = true;
			System.out.println("Pin ok");
		} else {
			istPinGueltig = false;
			System.out.println("Pin falsch");

		}

	}

	private void warte() {
		try {
			Thread.sleep(1000);
			System.out.println("Warte...");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void start() {
		thread.start();
	}

	private boolean pruefeKarte(Karte karte) {
		System.out.println("Prüfe Karte");

		if (karte.istGueltig) {
			return true;
		} else {
			return false;
		}

	}

	private void karteAuswerfen() {
		System.out.println("Karte wird ausgeworfen...");
		karteErkannt = false;
		istKarteGueltig = false;
		istPinGueltig = false;
		karte = null;
		zustand = START;
	}

	private void zeigeAuswahl() {
		int wahl;

		Scanner sc = new Scanner(System.in);

		System.out.println("1. Betrag auszahlen");
		System.out.println("2. Betrag überweisen");

		wahl = sc.nextInt();

		switch (wahl) {
		case 1:
			zustand = AUSZAHLEN;
			break;
		case 2:
			zustand = UEBERWEISEN;
			break;

		}
		sc.close();
		sc = null;

	}

	private void auszahlen() {
		System.out.println("Auszahlen gewählt");
		do {
			warte();
		} while (!bestaetigenGedrueckt);
	}

	private void ueberweisen() {
		System.out.println("Überweisen gewählt");
		do {
			warte();
		} while (!bestaetigenGedrueckt);
	}
}
