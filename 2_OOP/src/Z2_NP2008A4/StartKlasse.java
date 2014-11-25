package Z2_NP2008A4;

import javax.swing.SwingUtilities;

public class StartKlasse {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				
				Benutzeroberflaeche b = new Benutzeroberflaeche();
				
				/**
				 * Spielsteuerung kennt die Benutzeroberflaeche
				 */
				SpielSteuerung s = new SpielSteuerung(b);

			}
		});

	}

}
