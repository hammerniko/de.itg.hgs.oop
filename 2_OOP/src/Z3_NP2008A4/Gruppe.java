package Z3_NP2008A4;

import java.awt.Color;
import java.util.Vector;

/**
 * Richtiger objektorientierter Ansatz  der Aufgabe
 * @author nikolaihammer
 *
 */


public class Gruppe {
	
	private int nummer;
	private Color farbe;
	private Vector<Feld> felder;
	private static int anzahlGruppen=0;
	private static final int MAX_GRUPPENSUMME = 15;
	
	public Gruppe(Feld feld) {
		anzahlGruppen++;
		nummer = anzahlGruppen;
		
		felder = new Vector<Feld>();
		addFeld(feld);
		
		farbe = new Color(255-nummer*10,255-nummer*10,255-nummer*10);
	}

	public void addFeld(Feld feld){
		felder.add(feld);
	}
	
	public void removeFeld(int index){
		felder.remove(index);
	}
	
	
	

	private int gibGruppenSum(){
		return 0;
	}


	public int getNummer() {
		return nummer;
	}


	public void setNummer(int nummer) {
		this.nummer = nummer;
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
