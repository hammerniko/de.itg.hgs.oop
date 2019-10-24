package Z8_HP2001_Minesweeper;

public class SpielDaten {
	
	public static final int ANZAHL_FELDER = 5;
	
	//Attribute
	private int[][] spielBrettDatenFeld;
	private int anzahlMinen;
	private int anzahlFelder;
	
	public SpielDaten() {
		spielBrettDatenFeld = new int[ANZAHL_FELDER][ANZAHL_FELDER];
		
	}
	
	public void initialisiereSpielFeldDaten() {
	for (int x = 0; x < ANZAHL_FELDER; x++) {
			for (int y = 0; y < ANZAHL_FELDER; y++) {
				spielBrettDatenFeld[x][y]=0;
			}
		}
	}

	public int getAnzahlMinen() {
		return anzahlMinen;
	}

	public void setAnzahlMinen(int anzahlMinen) {
		this.anzahlMinen = anzahlMinen;
	}

	public int getAnzahlFelder() {
		return anzahlFelder;
	}

	public void setAnzahlFelder(int anzahlFelder) {
		this.anzahlFelder = anzahlFelder;
	}
	
	
	public int leseDatenFeld(int xpos, int ypos) {
		int value;
		
		value = spielBrettDatenFeld[xpos][ypos];
		
		
		return value;
	}
	
	public void schreibeDatenFeld(int xpos, int ypos, int wert) {
		
		spielBrettDatenFeld[xpos][ypos]=wert;
		
	}
	
	
	

}
