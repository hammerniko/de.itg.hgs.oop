package A01_Klassen_Uebung_Schueler;
/**
 * Nur ein Schueler darf Klassensprecher, bzw. stvKlassensprecher sein.
 * Problematik mehrerer Klassen wird in dieser Übung noch nicht berücksichtigt,
 * da Assoziationen zu anderen Java-Klassen noch folgen.
 * Ferner wird angenommen, dass alle Schüler in einem Array in der Klasse ErzeugeSchueler.java 
 * verwaltet werden.
 * 
 * @author nikolaihammer
 *
 */

public class Schueler {
	// KONSTANTEN
	public static final char gruppeA = 'A';
	public static final char gruppeB = 'B';

	// KLASSENVARIABLEN
	private static int anzahlSchueler = 0;
	private static String klassensprecher = "";
	private static String stvKlassensprecher = "";

	// OBJEKTATTRIBUTE
	private String name;
	private String vorname;
	private char gruppe;
	

	// KONSTRUKTOR
	public Schueler(String name, String vorname, char gruppe) {
		anzahlSchueler++;
		this.name = name;
		this.vorname = vorname;
		setGruppe(gruppe);
		
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

	
	
	public static int getAnzahlSchueler() {
		return anzahlSchueler;
	}

	

	public static String getKlassensprecher() {
		return klassensprecher;
	}
	
	public static void setKlassensprecher(Schueler schueler){
		klassensprecher = schueler.getName();
	}



	public static String getStvKlassensprecher() {
		return stvKlassensprecher;
	}



	public static void setStvKlassensprecher(Schueler schueler) {
		stvKlassensprecher=schueler.getName();
	}



	@Override
	public String toString() {
		
		return "Schueler [name=" + name + ", vorname=" + vorname + ", gruppe="
				+ gruppe + "]";
	}
	
	

}
