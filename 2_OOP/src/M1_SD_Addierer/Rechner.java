package M1_SD_Addierer;

public class Rechner {
	
	//Zeiger für Bidirektionale Assoziatioen
	Gui dieGui;
	
	private int anzahlRechnungen;
	
	public Rechner(Gui g){
		//Bidirektionale Assoziation herstellen
		dieGui = g;
		
		anzahlRechnungen=0;
	}
	
	
	
	public double berechneSumme(double z1, double z2){
		anzahlRechnungen++;
		dieGui.zeigeAnzahlRechnungen(anzahlRechnungen);
		return z1 + z2;
	}

}
