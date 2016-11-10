package D2_VererbungUndGrafik;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class MeinPanel extends JPanel implements MouseMotionListener {

	/**
	 * Konstanten
	 */
	private static final long serialVersionUID = 1L;
	static final int FADENKREUZ_KREIS_KLEIN = 25;
	static final int FADENKREUZ_KREIS_MITTEL = 50;
	static final int FADENKREUZ_KREIS_GROSS = 75;
	static final int FADENKREUZ_LINIE = 50;

	int h, b;
	int x, y; 		// Mausposition
	int xRel, yRel; // korrigierte Position abh. vom durchmesser des Fadenkreuzkreises

	private Image img = null; //Hintergundbild
	
	
	public MeinPanel() {
		/**
		 * Fügt dem Panelobjekt einen Listener hinzu, der auf Mausbewegungen hört.
		 * Der Uebergabeparameter sorgt dafür, das ein erzeugtes MouseMotion Event-Objekt
		 * an die Methoden mouseMoved bzw. mouseDragged uebergeben wird.
		 * Die Methoden sind vorhanden, da das MouseMotionListener Interface implementiert wurde.
		 */
		addMouseMotionListener(this);
		ladeImage();
	}

	/**
	 * Ueberschreiben der Standard Methode zum zeichnen der Komponente.
	 * Ueber das graphics-Objekt lassen sich die Standard Methoden zum zeichnen
	 * von Linien, Rechteckecken, Kreises usw. aufrufen.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		/**Das JPanel soll erst mal gezeichnet werden wie ein Standard JPanel*/
		super.paintComponent(g);

		/**Merken der aktuellen breite und höhe*/
		b = getWidth();
		h = getHeight();

		/**
		 * Fuer komplexere grafische darstellungen kann die Graphics2d Klasse
		 * verwendet werden. Damit sind z.b: dickere Linien, Schatten usw.
		 * moeglich.
		 */
		Graphics2D g2 = (Graphics2D) g;
		
		g2.drawImage(img, 0, 0, b, h,this);
		
		
		/**Setzen der Farbe zum zeichnen */
		g2.setColor(Color.BLUE);

		setzeLinienstaerke(g2);
		zeichneFadenkreuz(g2);

	}

	private void setzeLinienstaerke(Graphics2D g2) {
		BasicStroke linienstaerke = new BasicStroke(2.0f,BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);
		g2.setStroke(linienstaerke);
	}

	private void zeichneFadenkreuz(Graphics2D g2) {
		xRel = x - (FADENKREUZ_KREIS_GROSS / 2);
		yRel = y - (FADENKREUZ_KREIS_GROSS / 2);
		g2.drawOval(xRel, yRel, FADENKREUZ_KREIS_GROSS, FADENKREUZ_KREIS_GROSS);

		xRel = x - (FADENKREUZ_KREIS_MITTEL / 2);
		yRel = y - (FADENKREUZ_KREIS_MITTEL / 2);
		g2.drawOval(xRel, yRel, FADENKREUZ_KREIS_MITTEL,
				FADENKREUZ_KREIS_MITTEL);

		xRel = x - (FADENKREUZ_KREIS_KLEIN / 2);
		yRel = y - (FADENKREUZ_KREIS_KLEIN / 2);
		g2.drawOval(xRel, yRel, FADENKREUZ_KREIS_KLEIN, FADENKREUZ_KREIS_KLEIN);

		g2.drawLine(x, y - FADENKREUZ_LINIE, x, y + FADENKREUZ_LINIE);
		g2.drawLine(x - FADENKREUZ_LINIE, y, x + FADENKREUZ_LINIE, y);

		hideCursor();

	}

	/**
	 * Versteckt den Mouse-Cursor 
	 */
	private void hideCursor() {
		Image cursorImage = new BufferedImage(1, 1, BufferedImage.TYPE_4BYTE_ABGR);
		Point cursorPoint = new java.awt.Point(0, 0);
		Cursor cursor = java.awt.Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, cursorPoint, "nocursor");
		setCursor(cursor);
	}

	/**
	 * Methoden mouseDragged,mouseMoved die das Interface MouseMotionListener erzwingt.
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		//nichts machen
	}

	/**
	 * Diese Methode wird aufgerufen, wenn die Maus über das Panel bewegt wird.
	 * 
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		/**
		 * aktuellen x-y Wert der Maus merken.
		 */
		x = e.getX();
		y = e.getY();
		
		/**
		 * ganzes Panel neu zeichen, wenn die Maus bewegt wird.
		 * D.h. die Methode paintKomponent() wird aufgerufen.
		 */
		repaint();

	}
	
	private void ladeImage(){
		img = java.awt.Toolkit.getDefaultToolkit().getImage("src/D2_VererbungUndGrafik/hg2.jpg");
	}

}
