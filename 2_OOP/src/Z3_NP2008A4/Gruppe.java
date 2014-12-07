package Z3_NP2008A4;

import java.awt.Color;
import java.util.Vector;

/**
 * Datenobjekt für eine Gruppe von Feldern 
 * @author nikolaihammer
 *
 */


public class Gruppe {
	
	private int nr;
	private Color farbe;
	private Vector<Feld> felder;
	private static int anzahlGruppen=0;
	private static final int MAX_GRUPPENSUMME = 15;
	
	/**
	 * Eine Gruppe mit mindestens einem Feld
	 * @param feld
	 */
	public Gruppe(Feld feld) {
		anzahlGruppen++;
		nr = anzahlGruppen;
		
		felder = new Vector<Feld>();
		addFeld(feld);
		
		farbe = new Color(255-nr*10,255-nr*10,255-nr*10);
	}

	public void addFeld(Feld feld){
		felder.add(feld);
	}
	
	public void removeFeld(int x, int y){
		
	}
	
	
	

	private int gibGruppenSum(){
		return 0;
	}


	public int getNummer() {
		return nr;
	}


	public void setNummer(int nummer) {
		this.nr = nummer;
	}


	public Color getFarbe() {
		return farbe;
	}


	public void setFarbe(Color farbe) {
		this.farbe = farbe;
	}


	public Vector<Feld> getFelder() {
		return felder;
	}


	public void setFelder(Vector<Feld> felder) {
		this.felder = felder;
	}
	
	
}
