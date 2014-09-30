package A00_Klassen;


import java.util.Date;

//A1 Klasse 
public class Schueler {

	// A2 Attribute
	private String name;
	private String vorname;
	private Date gebDatum;

	//Konstruktor
	public Schueler(String name, String vorname,Date gebDatum){
		this.name = name;
		this.vorname = vorname;
		this.gebDatum = gebDatum ;
	}
	
	
	public Schueler(String name, String vorname){
		this.name = name;
		this.vorname = vorname;
		gebDatum = null;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		
		if(name.length()>=3){
			this.name = name;
		}
		
	}


	public String getVorname() {
		return vorname;
	}


	public void setVorname(String vorname) {
		this.vorname = vorname;
	}


	public Date getGebDatum() {
		return gebDatum;
	}


	public void setGebDatum(Date gebDatum) {
		this.gebDatum = gebDatum;
	}


	@Override
	public String toString() {
		return "Schueler [name=" + name + ", vorname=" + vorname
				+ ", gebDatum=" + gebDatum + "]";
	}


	


	

	


	
	
}
