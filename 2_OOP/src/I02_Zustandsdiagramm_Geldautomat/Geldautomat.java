package I02_Zustandsdiagramm_Geldautomat;

import java.util.Scanner;
/*
 * Ein Automtat muss immer nebenläufig implementiert werden, damit
 * die Bedienung des Hauptprogramms nicht blockiert wird.
 * Hier wird das Interface Runnable verwendet. Dieses erzwingt die
 * Implementierung der run()-Methode. Diese run()-Methode soll nebenläufig
 * abgearbeitet werden.
 * Dazu wird in der Klasse ein Thread-Objekt deklariert und im Konstruktor erzeugt.
 * Der Aufruf der run()-Methode erfolgt indirekt über den Aufruf der start()-Methode des
 * Thread-Objektes.
 */
public class Geldautomat implements Runnable {

	//Objektvariablen des Geldautomaten
	private int zustand; 					//aktueller Zustand des Geldautomaten
	private Thread thread;					//Thread Objekt für Nebenläufigkeit
	private boolean istKarteGueltig;		//wird gesetzt, wenn Karte gueltig ist 
	private boolean istPinGueltig;			//wird gesetzt, wenn PIN gueltig ist
	private boolean karteErkannt;			//wird gesetzt, wenn eine Karte eingeschoben wurde
	private boolean bestaetigenGedrueckt;	//wird gesetzt, wenn "bestätigen" gedrückt wurde 
	private Karte karte;

	//Zustandsvariablen als Konstanten
	public static final int AUS = 0;
	public static final int START = 1;
	public static final int KARTEN_PRUEFUNG = 2;
	public static final int PIN_EINGABE = 3;
	private static final int AUSZAHLEN = 4;
	private static final int UEBERWEISEN = 5;

	//Konstruktor
	public Geldautomat() {
		karte = null;
		karteErkannt = false;
		istKarteGueltig = false;
		istPinGueltig = false;
		bestaetigenGedrueckt = false;
		zustand = START; // Anfagszustand
		
		//Thread Objekt für Nebenläufigkeit erzeugen
		thread = new Thread(this);
		
	}

	/**
	 * Die run()-Methode beinhaltet den Lebenszyklus des Geldautomaten.
	 * Sie wird indirekt über die start()-Methode Thread-Objekts der Klasse aufgerufen.
	 * Dieser Aufruf sollte von aussen erfolgen, um Laufzeitprobleme zu verhindern.
	 * @see startGeldautomat.java
	 */
	@Override
	public void run() {

		// Switch-While-IDIOM - Lebenszyklus des Geldautomaten
		// Solange die äussere While-Schleife lüft, ist der Automat aktiv
		while (zustand != AUS) {
			
			//Hier wird zum aktuellen Zustand gesprungen. Jedem Zustand ist eine
			//Methode zugeordnet, welche den jeweiligen Zustand bearbeitet und Folgezustände
			//gemäß dem Zustandsdiagramm festlegt.
			//Ist ein Zustand zuende, sorgt der break Befehl dafür, das die Switch-Case
			//Anweisung verlassen wird. D.h. der Thread befindet sich dann wieder in der
			//äusseren while-Schleife und die switch-case Anweisung wird erneut aufgerufen.
			switch (zustand) {
			case START:       		zustandStart(); break;

			case KARTEN_PRUEFUNG:  	zustandPruefeKarte(); break;

			case PIN_EINGABE:   	zustandPinEingabe();	break;

			case AUSZAHLEN: 		zustandAuszahlen(); 	break;

			case UEBERWEISEN: 		zustandUeberweisen(); 	break;
			}
		}
	}

	private void zustandPruefeKarte() {
		//Prüfen ob die Karte gültig ist
		if (pruefeKarte(karte)) {
			istKarteGueltig = true;

			System.out.println("Karte gültig");
			zustand = PIN_EINGABE;
		} else {
			istKarteGueltig = false;
			karteAuswerfen();
		}
	}

	private void zustandStart() {
		
		//Solange keine Karte erkannt wird, wartet der Automat
		while (!karteErkannt) {
			warte();
			warte();
			// Für Beispielszenario karte wird nach einem wartezyklus erkannt
			karteErkannt = true;
			
			//Daten der Karte werden eingelesen und es wird ein Objekt erstellt,
			//um die Kartendaten zuverwalten.
			karte = new Karte(1234, true);
		}
		zustand = KARTEN_PRUEFUNG;
	}

	private void zustandPinEingabe() {
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

	public void starteThread() {
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

	private void zustandAuszahlen() {
		System.out.println("Auszahlen gewählt");
		do {
			warte();
		} while (!bestaetigenGedrueckt);
	}

	private void zustandUeberweisen() {
		System.out.println("Überweisen gewählt");
		do {
			warte();
		} while (!bestaetigenGedrueckt);
	}
}
