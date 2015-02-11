package D2_VererbungUndGrafik;

import java.awt.HeadlessException;

import javax.swing.JFrame;

public class Gui extends JFrame {
	
	MeinPanel meinPanel;

	public Gui()  {
		
		meinPanel =  new MeinPanel();
		setContentPane(meinPanel);
		setSize(300,300);
		
	}
	
	
	public static void main(String[] args){
		Gui gui = new Gui();
		gui.setVisible(true);
	}
	
	
	
	
}
