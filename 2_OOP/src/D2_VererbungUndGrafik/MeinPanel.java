package D2_VererbungUndGrafik;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MeinPanel extends JPanel {

	
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		
		g.setColor(Color.BLUE);
		g.drawLine(0, 0, 50, 50);
		
		g.setColor(Color.red);
		g.drawLine(50, 50, 60, 150);
		
		
	}
	
	
	
	
		
	
}
