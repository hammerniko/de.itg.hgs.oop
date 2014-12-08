package Z3_NP2008A4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MyButton extends JButton{
		
		Feld dasFeld;
	
	public MyButton(int x, int y){
		
		//Neues Feld mit Zufallswert
		dasFeld = new Feld(x, y);
		setText(""+dasFeld.getWert());
		setBackground(Color.GRAY);
	}
	
	//Setzen der Daten 
	public void setFeld(Feld feld){
		dasFeld = feld;
	}
	
	//Holen der Daten
	public Feld getFeld(){
		return dasFeld;
	}
	
	public void setWert(int wert){
		dasFeld.setWert(wert);
		setText(""+wert);
	}
	
	//Vorsicht! Die Methode darf nicht getX() heißen, da dies dann
	//eine bestehende Methode von JComponent überschreibt.
	//Es führt zu einer unkorrekten Darstellung der Buttons
	//Sie erscheinen erst, wenn man mit der Maus darüberfährt.
	public int getXPos(){
		return dasFeld.getPosX();
	}
	
	public int getYPos(){
		return dasFeld.getPosY();
	}
	
	
	
}
