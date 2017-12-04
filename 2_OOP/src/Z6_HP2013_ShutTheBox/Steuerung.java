package Z6_HP2013_ShutTheBox;

public class Steuerung {
	
	Spieler dieSpieler[];
	
	private int aAugensumme;
	private int aKLappenSumme;
	private int aIdxAktiverSpieler;
	private int aMinusPunkte;

	public Steuerung() {
		dieSpieler = new Spieler[2];
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
}
