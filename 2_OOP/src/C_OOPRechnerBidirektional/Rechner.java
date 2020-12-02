package C_OOPRechnerBidirektional;

public class Rechner {
	
	//Assoziation vorbereiten
	Gui dieGui;
		
	public Rechner(Gui gui) {
		//Assoziation herstellen
		dieGui = gui;
		
		
	}

	public double addiere(double zahlA, double zahlB){
		dieGui.aktualisiereStatus("berechne...");
		
		double erg = zahlA+zahlB;
		
		dieGui.aktualisiereStatus("fertig");
		
		return erg;
	}

	
	

}
