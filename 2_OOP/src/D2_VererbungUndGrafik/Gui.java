package D2_VererbungUndGrafik;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class Gui extends JFrame {
	
	MoorhuhnPanel meinPanel;

	public Gui()  {
		
		meinPanel =  new MoorhuhnPanel();
		
		setContentPane(meinPanel);
		setMaximized();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}


	private void setMaximized() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(dimension.width,dimension.height);
	}
	
	
	public static void main(String[] args){
		Gui gui = new Gui();
		gui.setVisible(true);
	}
	
	
	
	
}
