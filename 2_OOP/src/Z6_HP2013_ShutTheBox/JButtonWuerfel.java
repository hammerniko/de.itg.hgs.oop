package Z6_HP2013_ShutTheBox;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.border.Border;

public class JButtonWuerfel extends JButton {

	private int wert;
	private int width, height;
	private int mitteX, mitteY, spalteLinks, spalteRechts,reihe1, reihe2, reihe3, gap;
	
	public static final int RADIUS_CIRCLE = 7;

	public JButtonWuerfel(int wert) {
		super();
		this.wert = wert;
		setBackground(Color.WHITE);
		setText(" ");
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.BLACK);
		g2.setRenderingHint(
                 RenderingHints.KEY_ANTIALIASING, 
                 RenderingHints.VALUE_ANTIALIAS_ON);

		width = getSize().width;
		height = getSize().height;
		
		mitteX = width/2 - RADIUS_CIRCLE/2;
		mitteY = height/2 - RADIUS_CIRCLE/2;
		spalteLinks = width/4 - RADIUS_CIRCLE/2;
		spalteRechts = width - spalteLinks- RADIUS_CIRCLE;
		
		gap=(height-(3*RADIUS_CIRCLE))/4;
				
		reihe2 = height - (height/2)  -RADIUS_CIRCLE/2;
		reihe1 = reihe2-gap-RADIUS_CIRCLE;
		reihe3 = reihe2+gap+RADIUS_CIRCLE;

		switch (wert) {
		case 1:
			zeichneEins(g2);
			break;
		case 2:
			zeichneZwei(g2);
			break;
		case 3:
			zeichneDrei(g2);
			break;
		case 4:
			zeichneVier(g2);
			break;
		case 5:
			zeichneFuenf(g2);
			break;
		case 6:
			zeichneSechs(g2);
			break;

		}

	}

	private void zeichneSechs(Graphics2D g) {
		g.fillOval(spalteLinks, reihe1, RADIUS_CIRCLE, RADIUS_CIRCLE);
		g.fillOval(spalteLinks, reihe2, RADIUS_CIRCLE, RADIUS_CIRCLE);
		g.fillOval(spalteLinks, reihe3, RADIUS_CIRCLE, RADIUS_CIRCLE);
		g.fillOval(spalteRechts, reihe1, RADIUS_CIRCLE, RADIUS_CIRCLE);
		g.fillOval(spalteRechts, reihe2, RADIUS_CIRCLE, RADIUS_CIRCLE);
		g.fillOval(spalteRechts, reihe3, RADIUS_CIRCLE, RADIUS_CIRCLE);

	}

	private void zeichneFuenf(Graphics2D g) {
		g.fillOval(spalteLinks, reihe1, RADIUS_CIRCLE, RADIUS_CIRCLE);
		g.fillOval(spalteLinks, reihe3, RADIUS_CIRCLE, RADIUS_CIRCLE);
		g.fillOval(spalteRechts, reihe1, RADIUS_CIRCLE, RADIUS_CIRCLE);
		g.fillOval(mitteX, mitteY, RADIUS_CIRCLE, RADIUS_CIRCLE);
		g.fillOval(spalteRechts, reihe3, RADIUS_CIRCLE, RADIUS_CIRCLE);

	}

	private void zeichneVier(Graphics2D g) {
		g.fillOval(spalteLinks, reihe1, RADIUS_CIRCLE, RADIUS_CIRCLE);
		g.fillOval(spalteLinks, reihe3, RADIUS_CIRCLE, RADIUS_CIRCLE);
		g.fillOval(spalteRechts, reihe1, RADIUS_CIRCLE, RADIUS_CIRCLE);
		g.fillOval(spalteRechts, reihe3, RADIUS_CIRCLE, RADIUS_CIRCLE);

	}

	private void zeichneDrei(Graphics2D g) {
		g.fillOval(spalteLinks, reihe1, RADIUS_CIRCLE, RADIUS_CIRCLE);
		g.fillOval(mitteX, mitteY, RADIUS_CIRCLE, RADIUS_CIRCLE);
		g.fillOval(spalteRechts, reihe3, RADIUS_CIRCLE, RADIUS_CIRCLE);
	}

	private void zeichneZwei(Graphics2D g) {
		g.fillOval(spalteLinks, reihe1, RADIUS_CIRCLE, RADIUS_CIRCLE);
		g.fillOval(spalteRechts, reihe3, RADIUS_CIRCLE, RADIUS_CIRCLE);

	}

	private void zeichneEins(Graphics2D g) {
		g.fillOval(mitteX, mitteY, RADIUS_CIRCLE, RADIUS_CIRCLE);

	}

	public int getWert() {
		return wert;
	}

	public void setWert(int wert) {
		this.wert = wert;
	}
	
	

}
