package Z3_NP2008A4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MyButton extends JButton {
	
		Feld dasFeld;
	
	public MyButton(Feld feld){
		dasFeld = feld;
		setText(""+dasFeld.getWert());
		setBackground(Color.GRAY);
		
	}
}
