package A01_Klassen_Uebung_Schueler;

public class Schueler {
	//KONSTANTEN
	public static final String rolleSchueler = "Schueler";
	public static final String rolleKlassensprecher = "Klassensprecher";
	public static final String rolleStvKlassensprecher = "stv. Klassensprecher";

	public static final char gruppeA = 'A';
	public static final char gruppeB = 'B';
		
	//KLASSENVARIABLEN
	private static int anzahlSchueler=0;
		
	//OBJEKTATTRIBUTE
	private String name;
	private String vorname;
	private char gruppe;
	private String rolle; //Nur ein Sch?ler darf Klassensprecher, bzw. stv Klassensprecher sein.
	
	
	//KONSTRUKTOR
	public Schueler(String name, String vorname, char gruppe) {
		this.name = name;
		this.vorname = vorname;
		this.gruppe = gruppe;
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
		this.gruppe = gruppe;
	}


	public String getRolle() {
		return rolle;
	}


	public void setRolle(String rolle) {
		this.rolle = rolle;
	}


	public static int getAnzahlSchueler() {
		return anzahlSchueler;
	}


	@Override
	public String toString() {
		return "Schueler [name=" + name + ", vorname=" + vorname + ", gruppe="
				+ gruppe + ", rolle=" + rolle + "]";
	}
	
	
	
	
	
	

}
