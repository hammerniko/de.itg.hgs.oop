package C_OOPRechnerBidirektional;

public class Rechner {
	
	//Assoziation
	Gui dieGui;
	
		
	public double addiere(double zahlA, double zahlB){
		
		
		
		double erg = zahlA+zahlB;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		dieGui.aktualisiereStatus("fertig");
		
		return erg;
	}


	public void linkGui(Gui gui) {
		dieGui = gui;
		
	}
	
	

}
