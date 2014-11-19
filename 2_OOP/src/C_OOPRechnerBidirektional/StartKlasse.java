package C_OOPRechnerBidirektional;

public class StartKlasse {

	public static void main(String[] args) {

		
		Rechner r = new Rechner();
		
		Gui gui = new Gui(r);
		gui.setVisible(true);
		
		
		

	}

}
