package A001_Klassen;

import java.util.Date;

public class Schueler1{

	// Objektattribute
	private String name;
	private String vorname;
	private Date gebDatum;

	// Standardkonstruktor
	// initialisieren aller Objektattribute
	public Schueler1(String pName, String pVorname) {
		name = pName;
		setVorname(pVorname);
		gebDatum = null;
	}
	
	
	
	

	
	public String getName() {
		return name;
	}

	public void setVorname(String pVorname) {
		
		if(pVorname.length()>3) {
			vorname = pVorname;
		}
		
		
	}






	@Override
	public String toString() {
		return "Schueler1 [name=" + name + ", vorname=" + vorname + ", gebDatum=" + gebDatum + "]";
	}
	
	
	

}
