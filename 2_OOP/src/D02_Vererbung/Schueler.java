package D02_Vererbung;

import java.util.Date;

public class Schueler extends Person {
	
	private Date gebDatum;

	public Schueler(String name, String vorname) {
		super(name, vorname);
		
		gebDatum = null;
		
		
	}

	public Date getGebDatum() {
		return gebDatum;
	}
	
	@Override
	public String toString() {
		
		return super.toString() +" gebDatum "+gebDatum;
	}
	

	
}
