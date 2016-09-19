package A00_Wdh;
import java.util.Date;


public class Schueler {
	
	//objektattribute
	private String name;
	private String vorname;
	private Date gebDatum;
	
	//Konstruktor
	public  Schueler(String pName, String vorname) {
		setName(pName);
		this.vorname = vorname;
		
		gebDatum = new Date("09/19/2016");
	}

	
	//getter und setter
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
