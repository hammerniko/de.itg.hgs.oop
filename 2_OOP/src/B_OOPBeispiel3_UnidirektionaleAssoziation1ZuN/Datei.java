package B_OOPBeispiel3_UnidirektionaleAssoziation1ZuN;

import java.util.Date;


public class Datei {
	
	private String name=null;
	private String endung=null;
	private Date erstelltAm=null;
	private int groesse=0;
	

	
	public Datei(String name, String endung) {
	   
	    this.erstelltAm = new Date();
	    this.name = name;
	    this.endung = endung;
    }
	
	public String getName() {
    	return name;
    }
	public void setName(String name) {
    	this.name = name;
    }
	
	public String getEndung() {
    	return endung;
    }
	public void setEndung(String endung) {
    	this.endung = endung;
    }
	
	public Date getErstelltAm() {
    	return erstelltAm;
    }
	public int getGroesse() {
    	return groesse;
    }

	@Override
    public String toString() {
	    return "\n\t"+name + "." + endung + "\t"+ erstelltAm + "\t" + groesse ;
    }
	
	
	
}
