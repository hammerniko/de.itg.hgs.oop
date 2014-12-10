package Z3_NP2008A4;

import javax.swing.JButton;

/**
 * Datenobjekt für ein Spielfeld
 * @author nikolaihammer
 *
 */
public class Feld {
	
	@Override
	public String toString() {
		return "Feld [grp = "+gruppennummer+" | wert=" + wert + " | x=" + posX + ", y=" + posY + "]";
	}

	private int wert;
	private int posX;
	private int posY;
	private int gruppennummer;
	public static int anzahlFelder = 0;
	private int id;
	
	public int getGruppennummer() {
		return gruppennummer;
	}


	public void setGruppennummer(int gruppennummer) {
		this.gruppennummer = gruppennummer;
	}


	public Feld( int posX, int posY) {
		anzahlFelder++;
		id=anzahlFelder;
		
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
