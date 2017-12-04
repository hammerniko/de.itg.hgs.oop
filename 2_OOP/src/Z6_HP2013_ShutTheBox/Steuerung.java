package Z6_HP2013_ShutTheBox;

public class Steuerung {
	
	Spieler dieSpieler[];
	Wuerfel dieWuerfel[];
	
	private int aAugensumme;
	private int aKLappenSumme;
	private int aIdxAktiverSpieler;
	private int aMinusPunkte;
	
	private Gui dieGui;

	public Steuerung(Gui gui) {
		dieGui = gui;
		dieSpieler = new Spieler[2];
		dieWuerfel = new Wuerfel[2];
		dieWuerfel[0] = new Wuerfel();
		dieWuerfel[1] = new Wuerfel();
	}
	
	public void wechsleSpieler() {
		
	}
	
	private int gibIdxNaechsterSpieler() {
		return 0;
	}
	
	private void setzeKlappenEndgueltigGeschlossen() {
		
	}
	
	public boolean computerZug() {
		return true;
	}

	public void wuerfeln() {
		int w1 = dieWuerfel[0].wuerfeln();
		int w2 = dieWuerfel[1].wuerfeln();
		
		dieGui.zeichneWuerfel(w1,w2);
		
	}
}
