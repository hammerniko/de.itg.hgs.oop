package Z2_NP2008A4;

import java.text.NumberFormat;
import java.util.Vector;

public class SpielDaten {
	
	

	// Attribute
	private int gruppennummer = 0;
	private int[][] wert = null;
	private int[][] gruppe = null;
	private int[] gruppenSum = null;
	private int[] grpNb;

	public SpielDaten() {
		wert = new int[6][6];
		gruppe = new int[6][6];
		gruppenSum = new int[36]; // summen der Gruppe 0,1,2,3
		grpNb = new int[8];
	}

	/**
	 * alle werte werden mit einer Zufallszahl initialisiert alle Gruppen werden
	 * gelöscht alle Gruppensummen werden gelöscht
	 */
	public void initialisiereSpielDaten() {
		for (int y = 0; y < wert.length; y++) {
			for (int x = 0; x < wert.length; x++) {

				// Erzeuge eine Zufallszahl zwischen 1 und 9
				wert[x][y] = (int) (Math.random() * 9 + 1);

				// Lösche alle gruppen
				gruppe[x][y] = 0;
			}

		}

		// Initialisiere die Gruppennummer
		gruppennummer = 0;

		// Lösche alle Gruppensummen
		for (int i = 0; i < gruppenSum.length; i++) {
			gruppenSum[i] = 0;
		}
	}

	public int[][] getWerte() {
		return wert;
	}

	/**
	 * Erstellt eine neue Gruppennummer und gibt sie zurück.
	 */
	public int gibNeueGruppe() {
		gruppennummer++;
		return gruppennummer;
	}

	/**
	 * Durchsucht alle Gruppenfelder nach der freizugebenden Gruppe und setzt
	 * sie zurück
	 * 
	 * @param gruppenr
	 */
	public void gibGruppeFrei(int gruppenr) {
		for (int y = 0; y < gruppe.length; y++) {
			for (int x = 0; x < gruppe.length; x++) {
				if (gruppe[x][y] == gruppenr) {
					gruppe[x][y] = 0;

				}
			}
		}
	}

	/**
	 * Ergebnis = -1 --> Feld erledigt Ergebnis = 0 --> Feld frei Ergebnis > 0
	 * --> Gruppennummer bei unvollständiger Gruppe
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public int gibGruppe(int x, int y) {
		//System.out.println(gruppe[x][y]);
		return gruppe[x][y];
	}

	/**
	 * Prüfz Anzahl unvollständiger Nachbargruppen Ergebnis 0 -> keine Ergebnis
	 * 1 -> eine Ergebnis 2 -> mehr als eine
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public int gibAnzahlNachbarn(int x, int y) {
		int anzahl = 0;
		// x nur erhöhen wenn x < xmax-1 = 4
		// y nur erhöhen wenn y y ymax-1 = 4
		// x nur erniedrigen wenn x > 1
		// y nur erniedrigen wenn y > 1

		// Wenn Inhalt der Gruppe bei xNachbar > 0
		// anzahl erhöhen
		
		//Initialisieren
		for (int i = 0; i < grpNb.length; i++) {
			grpNb[i]=-1;
		}

		if (x < 4)
			grpNb[0] = gibGruppe(x+1, y); // rechts

		if (x > 0)
			grpNb[1] = gibGruppe(x-1, y); // links
		if (y < 4)
			grpNb[2] = gibGruppe(x, y+1); // unten
		if (y > 0)
			grpNb[3] = gibGruppe(x, y-1); // oben
		if (y > 0 && x > 0)
			grpNb[4] = gibGruppe(x-1, y-1); // linke untere Ecke
		if (y < 4 && x < 4)
			grpNb[5] = gibGruppe(x+1, y+1); // rechte untere Ecke
		if (y > 0 && x < 4)
			grpNb[6] = gibGruppe(x+1, y-1); // rechte obere Ecke
		if (y < 4 && x > 0)
			grpNb[7] = gibGruppe(x-1, y+1); // linke obere Ecke

		for (int i = 0; i < grpNb.length; i++) {
			if (grpNb[i] > 0) {
				anzahl++;
				
			}
		}
		
		return anzahl;
	}

	public int gibEindeutNachbar_XPos(int x, int y) {
		
		int nachbargruppennummer=0;
		int xPos=0;
		
		for (int i = 0; i < grpNb.length; i++) {
			if(grpNb[i]>0){
				nachbargruppennummer = i;
				break;
			}
			
		}
		
		switch (nachbargruppennummer) {
		case 0: xPos = x+1; break;
		case 1: xPos = x-1; break;
		case 2: xPos = x; break;
		case 3: xPos = x; break;
		case 4: xPos = x-1; break;
		case 5: xPos = x+1; break;
		case 6: xPos = x+1; break;
		case 7: xPos = x-1; break;

		default:
			break;
		}
		
		return xPos;
		
	}

	public int gibEindeutNachbar_YPos(int x, int y) {
		
		int nachbargruppennummer=0;
		int yPos=0;
		
		//In einer der grpNB muss ein Wert größer 0 stehen
		//Wenn der gefunden wurde, kann abgebrochen werden.
		for (int i = 0; i < grpNb.length; i++) {
			if(grpNb[i]>0){
				nachbargruppennummer = i;
				break;
			}
			
		}
		
		switch (nachbargruppennummer) {
		case 0: yPos = y; break;
		case 1: yPos = y; break;
		case 2: yPos = y+1; break;
		case 3: yPos = y-1; break;
		case 4: yPos = y-1; break;
		case 5: yPos = y+1; break;
		case 6: yPos = y-1; break;
		case 7: yPos = y+1; break;

		default:
			break;
		
		}
		
		
		return yPos;
	}

	public int gibGruppenSum(int grpNr) {
		// TODO Auto-generated method stub
		return gruppenSum[grpNr];
	}

	public int gibWert(int x, int y) {
		// TODO Auto-generated method stub
		return wert[x][y];
	}

	/**
	 * Wird aufgerufen, wenn eine Gruppe erweitert wird.
	 * 
	 * @param x2
	 * @param y2
	 * @param grpNr
	 */
	public void fuegeZuGruppe(int x, int y, int grpNr) {
		gruppe[x][y] = grpNr;
	}

	/**
	 * Erhoeht den aktuellen Summenwert einer Gruppe um den Wert des neu
	 * hinzugefügten Feldes.
	 * 
	 * @param x1
	 * @param y1
	 * @param grpNr
	 */
	public void erhoeheGruppenSum(int x1, int y1, int grpNr) {
		
		gruppenSum[grpNr] = gruppenSum[grpNr]+gibWert(x1, y1);
		System.out.println("Neue Gruppensumme von "+grpNr+" = "+gruppenSum[grpNr]);

	}

	public int[][] getGruppe() {
		return gruppe;
	}

	/**
	 * Berechnet wieviel Prozent der Spielfelder bereits belegt sind 100% = 36
	 * Felder x% = x freie Felder mit
	 * 
	 * @return
	 */
	public double berechneSpielstand() {
		int anzahlFreieFelder = 0;
		for (int y = 0; y < gruppe.length; y++) {
			for (int x = 0; x < gruppe.length; x++) {
				if (gruppe[x][y] == 0) {
					anzahlFreieFelder++;
				}
			}
		}
		double spielstand = (1 - anzahlFreieFelder / 36.0);
		spielstand = Math.round(spielstand * 100.0) / 100.0;

		return spielstand;
	}

	public void schliesseGruppe(int grpNr) {
		for (int i = 0; i < gruppe.length; i++) {
			for (int j = 0; j < gruppe.length; j++) {
				if(gruppe[i][j]==grpNr && grpNr > 0 ){
					gruppe[i][j] = -1;
				}
			}
		}
		
	}
}
