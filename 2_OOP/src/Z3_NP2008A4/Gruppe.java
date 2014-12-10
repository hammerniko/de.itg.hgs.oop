package Z3_NP2008A4;

import java.awt.Color;
import java.util.Vector;

/**
 * Datenobjekt für eine Gruppe von Feldern
 * 
 * @author nikolaihammer
 *
 */
public class Gruppe {

	private static int anzGrp = 0;
	private int nr = 0;

	private Vector<Feld> grpFelder;
	private boolean istGruppeVoll = false;

	/**
	 * Eine Gruppe mit mindestens einem Feld
	 * 
	 * @param feld
	 */
	public Gruppe(Feld feld) {
		anzGrp++;
		nr = anzGrp;
		grpFelder = new Vector<Feld>();
		feld.setFarbe(gibZufallsfarbe());
		addFeld(feld);

		// Jede Gruppe hat eine andere Farbe
	}

	/**
	 * Fuegt ein angeklicktes Feld einer Gruppe hinzu, wenn die Summe der Gruppe
	 * kleiner oder gleich 15 ist. Bei Erfolg gibt die Methode true zurück
	 * 
	 * @param feld
	 * @return
	 */
	public boolean addFeld(Feld feld) {
		boolean gruppeHinzugefuegt = false;
		int summe = feld.getWert() + gibGruppenSum();

		if (summe <= 15) {

			grpFelder.add(feld);
			feld.setGruppennummer(nr);

			gruppeHinzugefuegt = true;

			if (gibGruppenSum() == 15) {
				istGruppeVoll = true;
			} else {
				istGruppeVoll = false;
			}
		}

		return gruppeHinzugefuegt;
	}

	public boolean removeFeld(Feld feld) {
		boolean gruppeRemoved = false;
		if (grpFelder.contains(feld)) {
			grpFelder.remove(feld);
			gruppeRemoved = true;
		}

		return gruppeRemoved;
	}

	/**
	 * Ermittelt dynamisch die Summe aller Feldwerte und gibt sie zurück
	 * 
	 * @return
	 */
	private int gibGruppenSum() {
		int summe = 0;
		for (int i = 0; i < grpFelder.size(); i++) {
			summe = summe + grpFelder.elementAt(i).getWert();
		}
		return summe;
	}

	public int getNummer() {
		return nr;
	}

	public void setNummer(int nummer) {
		this.nr = nummer;
	}

	

	/**
	 * Wird benötigt um alle Felder einer Gruppe als solche anzuzeigen
	 * 
	 * @return
	 */
	public Vector<Feld> getFelder() {
		return grpFelder;
	}

	private Color gibZufallsfarbe() {
		int z = (int) (Math.random() * 255 + 1);

		return new Color(z, z, z);

	}

	public static void setAnzGrp(int anzGrp) {
		Gruppe.anzGrp = anzGrp;
	}

}
