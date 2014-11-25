package Z2_NP2008A4;

import javax.swing.*;

public class Benutzeroberflaeche extends JFrame {
	
	//Deklaration für die Assoziation zur Steuerung
	SpielSteuerung dieSpielSteuerung;
	
	
	/**
	 * Wird aufgerufen wenn auf ein feld geklickt wurde.
	 * @param x
	 * @param y
	 */
	public void feldClick(int x, int y){
		
		dieSpielSteuerung.bearbeiteFeldClick(x,y);
		
	}

	/**
	 * zur Herstellung der bidirektionalen Assoziation
	 * @param spielSteuerung
	 */
	public void linkSteuerung(SpielSteuerung spielSteuerung) {
		dieSpielSteuerung = spielSteuerung;
	}

}
