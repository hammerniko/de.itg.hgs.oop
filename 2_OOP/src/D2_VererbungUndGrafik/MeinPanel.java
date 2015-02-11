package D2_VererbungUndGrafik;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;



public class MeinPanel extends JPanel {

	int h, b;
	
	/**
	 * Überschreiben der Standard Methode zum zeichnen der
	 * Komponente.
	 * 
	 * Über das graphics-Objekt lassen sich die Standard
	 * Methoden zum zeichnen von Linien, Rechteckecken, Kreises usw. aufrufen.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		b = getWidth();
		h = getHeight();
		
		 /**
		  * Für komplexere grafische darstellungen
		  * kann die Graphics2d Klasse verwendet werden.
		  * Damit sind z.b: dickere Linien, Schatten usw. möglich.
		  */
		 Graphics2D g2 = (Graphics2D) g;
		
		 /**
		  * Neue Linienstärke 
		  */
		 BasicStroke linienstaerke
         = new BasicStroke(2.0f, 
        		           BasicStroke.CAP_SQUARE, 
                           BasicStroke.JOIN_BEVEL);
		 
		g2.setStroke(linienstaerke);
		g2.setColor(Color.BLUE);
		
		//x-Achse
		g2.drawLine(0, h/2, b, h/2);
		g2.drawLine(b-10, (h/2)-5, b, h/2);
		g2.drawLine(b-10, (h/2)+5, b, h/2);
		g2.drawString("x", b-15, (h/2)+15);
		
		
		//y-Achse
		g2.setColor(Color.red);
		g2.drawLine(b/2, 0, b/2, h);
		g2.drawLine((b/2)-5, 10, b/2, 0);
		g2.drawLine((b/2)+5, 10, b/2, 0);
		g2.drawString("y",(b/2)+15, 15);
		
	}
	
	
	
	
		
	
}
