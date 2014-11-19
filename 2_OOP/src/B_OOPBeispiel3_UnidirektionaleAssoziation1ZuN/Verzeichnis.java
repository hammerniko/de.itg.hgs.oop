package B_OOPBeispiel3_UnidirektionaleAssoziation1ZuN;

import java.util.Date;
import java.util.Vector;

public class Verzeichnis {

	private String name;
	private Date erstelltAm;
	private static int anzNeueOrdner = 0;
	public static final String NAME_NEUER_ORDNER = "Neuer_Ordner";

	Vector<Datei> dieDateien;

	public Verzeichnis() {
		
		dieDateien = new Vector<Datei>();
		erstelltAm = new Date();

		if (anzNeueOrdner == 0) {
			name = NAME_NEUER_ORDNER;
		} else {
			name = NAME_NEUER_ORDNER + "(" + anzNeueOrdner + ")";
		}
		anzNeueOrdner++;
	}

	public Verzeichnis(String name) {
		
		dieDateien = new Vector<Datei>();
		erstelltAm = new Date();
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		name = name.trim(); //Entfernt Leerzeichen am Anfang und Ende
		if (!(name.isEmpty() || name == null)) {
			this.name = name;
		}
		
	}

	public Date getErstelltAm() {
		return erstelltAm;
	}

	
	
	public void addDatei(Datei datei) {
		dieDateien.add(datei);
	}

	public void removeDatei(int nr) {
		dieDateien.remove(nr);
	}

	public Datei getDatei(int nr) {
		return dieDateien.get(nr);
	}

	@Override
	public String toString() {
		return "\n" + name + "\t " + erstelltAm + dieDateien;
	}

}
