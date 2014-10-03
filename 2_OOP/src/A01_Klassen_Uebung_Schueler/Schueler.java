package A01_Klassen_Uebung_Schueler;

/**
 * Nur ein Schueler darf Klassensprecher, bzw. stvKlassensprecher sein.
 * Problematik mehrerer Klassen wird in dieser Übung noch nicht beruecksichtigt,
 * da Assoziationen zu anderen Java-Klassen noch folgen. Ferner wird angenommen,
 * dass alle Schueler in einem Array in der Klasse ErzeugeSchueler.java verwaltet
 * werden.
 * 
 * @author nikolaihammer
 * 
 */

public class Schueler {
	// KONSTANTEN
	public static final char GRUPPE_A = 'A';
	public static final char GRUPPE_B = 'B';

	// KLASSENVARIABLEN
	private static int anzahlSchueler = 0;
	private static String klassensprecher = "";
	private static String stvKlassensprecher = "";

	// OBJEKTATTRIBUTE
	private int id;          //Zur eindeutigen Identifikaten im Falle gleicher Namen
	private String name;
	private String vorname;
	private char gruppe;

	// KONSTRUKTOR
	public Schueler(String name, String vorname, char gruppe) {
		anzahlSchueler++;
		id=anzahlSchueler; //Auch wenn ein Schueler gelöscht wird, wird die id weiter hoch gezählt.
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
		if (gruppe == GRUPPE_A || gruppe == GRUPPE_B) {
			this.gruppe = gruppe;
		}
	}

	public static int getAnzahlSchueler() {
		return anzahlSchueler;
	}

	public static String getKlassensprecher() {
		return klassensprecher;
	}

	public static void setKlassensprecher(Schueler schueler) {
		String ks = schueler.getId()+" "+schueler.getName()+" "+schueler.getVorname();
		klassensprecher = ks;
	}

	public static String getStvKlassensprecher() {
		return stvKlassensprecher;
	}

	public static void setStvKlassensprecher(Schueler schueler) {
		String ks = schueler.getId()+" "+schueler.getName()+" "+schueler.getVorname();
		stvKlassensprecher = ks;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	@Override
	public String toString() {
		return "Schueler [id=" + id + ", name=" + name + ", vorname=" + vorname
				+ ", gruppe=" + gruppe + "]";
	}

	/**
	 * wird aufgerufen, wenn ein Schuelerobjekt geloescht wird. Damit der
	 * Garbagecollector direkt ausgefuehrt wird, und somit die Anzahl der Objekte
	 * stimmt, sollte nach dem Aufruf dieser Methode System.gc() aufgerufen
	 * werden.
	 */
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Schueler geloescht");

		anzahlSchueler--;
	}

}
