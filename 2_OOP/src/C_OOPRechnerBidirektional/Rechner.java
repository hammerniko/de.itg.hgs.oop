package C_OOPRechnerBidirektional;

public class Rechner {
	
	//Assoziation
	Gui dieGui;
	
		
	public double addiere(double zahlA, double zahlB){
		
		
		dieGui.aktualisiereStatus("berechne...");
		
		
		double erg = zahlA+zahlB;
		
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		Thread t = new Thread(r);
		t.start();
		
		
		dieGui.aktualisiereStatus("fertig");
		
		return erg;
	}


	public void linkGui(Gui gui) {
		dieGui = gui;
		
	}
	
	

}
