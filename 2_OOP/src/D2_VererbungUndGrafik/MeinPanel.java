package D2_VererbungUndGrafik;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;



public class MeinPanel extends JPanel implements MouseMotionListener{

	static final int FADENKREUZ_KREIS_KLEIN = 25;
	static final int FADENKREUZ_KREIS_MITTEL = 50;
	static final int FADENKREUZ_KREIS_GROSS = 75;
	static final int FADENKREUZ_LINIE = 50;
	
	int h, b;
	int x,y;	   //Mausposition
	int xRel,yRel; //korrigierte Position abh. vom durchmesser des Fadenkreuzkreises 
	
	public MeinPanel() {
		addMouseMotionListener(this);
	}
	
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
		 g2.setColor(Color.BLUE);
	
		setzeLinienstaerke(g2);
		zeichneFadenkreuz(g2);
		
	}

	private void setzeLinienstaerke(Graphics2D g2) {
		BasicStroke linienstaerke
         = new BasicStroke(2.0f, 
        		           BasicStroke.CAP_SQUARE, 
                           BasicStroke.JOIN_BEVEL);
		 
		g2.setStroke(linienstaerke);
		
	}

	private void zeichneFadenkreuz(Graphics2D g2) {
		xRel = x-(FADENKREUZ_KREIS_GROSS/2);
		yRel = y-(FADENKREUZ_KREIS_GROSS/2);
		g2.drawOval(xRel, yRel, FADENKREUZ_KREIS_GROSS, FADENKREUZ_KREIS_GROSS);
		
		xRel = x-(FADENKREUZ_KREIS_MITTEL/2);
		yRel = y-(FADENKREUZ_KREIS_MITTEL/2);
		g2.drawOval(xRel, yRel, FADENKREUZ_KREIS_MITTEL, FADENKREUZ_KREIS_MITTEL);
		
		xRel = x-(FADENKREUZ_KREIS_KLEIN/2);
		yRel = y-(FADENKREUZ_KREIS_KLEIN/2);
		g2.drawOval(xRel, yRel, FADENKREUZ_KREIS_KLEIN, FADENKREUZ_KREIS_KLEIN);
		
		
		g2.drawLine(x, y-FADENKREUZ_LINIE, x, y+FADENKREUZ_LINIE);
		g2.drawLine(x-FADENKREUZ_LINIE, y, x+FADENKREUZ_LINIE, y);
		
		hideCursor();
		
	}

	private void hideCursor() {
		Image cursorImage = new BufferedImage(1,1,BufferedImage.TYPE_4BYTE_ABGR);
		Point cursorPoint = new java.awt.Point(0,0);
		Cursor cursor = java.awt.Toolkit.getDefaultToolkit().createCustomCursor(cursorImage,cursorPoint,"nocursor");
		setCursor(cursor);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println(e);
		x = e.getX();
		y = e.getY();
		repaint();
		
	}
	
	
	
	
		
	
}
