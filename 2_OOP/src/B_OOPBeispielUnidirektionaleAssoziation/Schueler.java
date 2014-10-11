package B_OOPBeispielUnidirektionaleAssoziation;

public class Schueler {
    
    String name;
    String vorname;
    
    
    
    
    public Schueler(String name, String vorname) {
		
		this.name = name;
		this.vorname = vorname;
	}


	//Schulklasse Assoziation
    Schulklasse dieSchulklasse;
    
    
    public void setSchulklasse(Schulklasse schulklasse){
        dieSchulklasse = schulklasse;
    }


	@Override
	public String toString() {
		return "Schueler [name=" + name + ", vorname=" + vorname
				+ ", dieSchulklasse=" + dieSchulklasse + "]";
	}
    

}
