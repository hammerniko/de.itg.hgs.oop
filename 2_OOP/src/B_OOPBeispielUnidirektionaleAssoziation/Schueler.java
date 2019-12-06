package B_OOPBeispielUnidirektionaleAssoziation;

public class Schueler {
    //Objektattribute 
    String name;
    String vorname;
    
    //Schulklasse Assoziation
    Schulklasse dieSchulklasse;
    
    
    /**
     * Konstruktor fuer Schuelerobjekte.
     * @param name
     * @param vorname
     * @param schulklasse
     */
    public Schueler(String name, String vorname, Schulklasse schulklasse) {
		this.name = name;
		this.vorname = vorname;
		dieSchulklasse = schulklasse;
	}


	//Getter und Setter
    /**
     * Versetzt einen Schueler in eine neue Klasse
     * @param schulklasse
     */
    public void setSchulklasse(Schulklasse schulklasse){
        dieSchulklasse = schulklasse;
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


	public Schulklasse getDieSchulklasse() {
		return dieSchulklasse;
	}


	/**
     * Gibt alle Daten eines Schuelers als Text zurueck.
     * Da die Informationen der Schulklasse mit ausgegeben werden,
     * muss in der Klasse Schulklasse ebenfalls die toString Methode
     * ueberschrieben werden.
     */
	@Override
	public String toString() {
		return dieSchulklasse.getKlasse()+ " \t"+ name + " " + vorname;
	}
    

}
