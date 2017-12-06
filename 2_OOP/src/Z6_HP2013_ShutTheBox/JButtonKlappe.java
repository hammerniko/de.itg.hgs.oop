package Z6_HP2013_ShutTheBox;

import java.awt.Dimension;

import javax.swing.JButton;

public class JButtonKlappe extends JButton {
	
	public int wert;
	public static final String GESCHLOSSEN = "X";
	public static final int HEIGHT = 200;
	public static final int WIDTH = 50;
	
	public JButtonKlappe(int wert) {
		this.wert = wert;
		this.setPreferredSize(new Dimension( WIDTH,HEIGHT));
		this.setText(""+wert);
	}

}
