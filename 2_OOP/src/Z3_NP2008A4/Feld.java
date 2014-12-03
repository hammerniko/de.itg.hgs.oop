package Z3_NP2008A4;

import javax.swing.JButton;

/**
 * Richtiger objektorientierter Ansatz  der Aufgabe
 * @author nikolaihammer
 *
 */
public class Feld {
	
	@Override
	public String toString() {
		return "Feld [wert=" + wert + ", posX=" + posX + ", posY=" + posY + "]";
	}

	private int wert;
	private int posX;
	private int posY;
	
	public Feld( int posX, int posY) {
	
		this.wert = (int) (Math.random()*9+1);
		this.posX = posX;
		this.posY = posY;
		
		
	}

	
	public int getWert() {
		return wert;
	}

	public void setWert(int wert) {
		this.wert = wert;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	
	
	

}
