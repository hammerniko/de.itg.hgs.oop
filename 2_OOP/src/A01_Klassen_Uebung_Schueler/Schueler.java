package A01_Klassen_Uebung_Schueler;

public class Schueler {
	// KONSTANTEN
	public static final String rolleSchueler = "Schueler";
	public static final String rolleKlassensprecher = "Klassensprecher";
	public static final String rolleStvKlassensprecher = "stv. Klassensprecher";

	public static final char gruppeA = 'A';
	public static final char gruppeB = 'B';

	// KLASSENVARIABLEN
	private static int anzahlSchueler = 0;

	// OBJEKTATTRIBUTE
	private String name;
	private String vorname;
	private char gruppe;
	private String rolle; // Nur ein Sch?ler darf Klassensprecher, bzw. stv
							// Klassensprecher sein.

	// KONSTRUKTOR
	public Schueler(String name, String vorname, char gruppe, String rolle) {
		anzahlSchueler++;
		this.name = name;
		this.vorname = vorname;
		this.gruppe = gruppe;
		this.rolle = rolle;
	}

	public Schueler(String name, String vorname, char gruppe) {
		super();
		this.name = name;
		this.vorname = vorname;
		this.gruppe = gruppe;
		this.rolle = rolleSchueler;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public char getGruppe() {
		return gruppe;
	}

	public void setGruppe(char gruppe) {
		if (gruppe == gruppeA || gruppe == gruppeB) {
			this.gruppe = gruppe;
		}
	}

	public String getRolle() {
		return rolle;
	}
	/**
	 * Erlaubt das setzen einer Rolle, wenn sie den gegebenen Konstanten entspreicht.
	 * @param rolle
	 */
	public void setRolle(String rolle) {
		if(rolle==rolleKlassensprecher || rolle == rolleSchueler || rolle == rolleStvKlassensprecher){
			this.rolle = rolle;
		}
		
	}

	public static int getAnzahlSchueler() {
		return anzahlSchueler;
	}

	@Override
	public String toString() {
		
		String str = "Schueler [n=" + name + ",\tvn=" + vorname + ",\tgrp="
				+ gruppe + ",\trolle=" + rolle + "]";
		
		return str;
	}

}
