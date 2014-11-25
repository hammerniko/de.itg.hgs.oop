package Z2_NP2008A4;

import javax.swing.*;

public class Benutzeroberflaeche extends JFrame {
	SpielSteuerung dieSpielSteuerung;
	
	
	/**
	 * Wird aufgerufen wenn auf ein feld geklickt wurde.
	 * @param x
	 * @param y
	 */
	public void feldClick(int x, int y){
		
		dieSpielSteuerung.bearbeiteFeldClick(x,y);
		
	}

}
