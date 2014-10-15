package B_OOPBeispielUnidirektionaleAssoziation;

public class Schueler {
    
    String name;
    String vorname;
    
    //Schulklasse Assoziation
    Schulklasse dieSchulklasse;
    
    
    
    public Schueler(String name, String vorname, Schulklasse schulklasse) {
		
		this.name = name;
		this.vorname = vorname;
		dieSchulklasse = schulklasse;
	}


	
    //getter setter
    public void setSchulklasse(Schulklasse schulklasse){
        dieSchulklasse = schulklasse;
    }


	@Override
	public String toString() {
		return "Schueler [name=" + name + ", vorname=" + vorname
				+ ", dieSchulklasse=" + dieSchulklasse + "]";
	}
    

}
