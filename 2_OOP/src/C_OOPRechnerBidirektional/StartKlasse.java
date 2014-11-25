package C_OOPRechnerBidirektional;

import javax.swing.SwingUtilities;

public class StartKlasse {

	public static void main(String[] args) {

		
		
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				Rechner r = new Rechner();
				Gui gui = new Gui(r);
				gui.setVisible(true);
				
			}
		});
		
		
		
		

	}

}
