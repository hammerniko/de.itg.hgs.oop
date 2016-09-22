package A04_OOPErweiterungMit1zuN;

public class Schueler {
	
	private String name;
	private String vorname;
	
	
	Schulklasse dieKlasse;

	public Schueler(String name, String vorname) {
		this.name = name;
		this.vorname = vorname;
		dieKlasse = null;
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

	public Schulklasse getDieKlasse() {
		return dieKlasse;
	}

	
	public void setDieKlasse(Schulklasse klasse) {
		
		//Wenn der Sch�ler bereits einer Klasse zugeordnet wurde
		if(dieKlasse!=null){
			
			//Entferne den Sch�ler aus der alten Klasse
			dieKlasse.removeSchueler(this);
			dieKlasse = null;
			
			//F�ge den Sch�ler in der neuen Klasse hinzu
			klasse.addSchueler(this);
		}
		else{
			dieKlasse = klasse;
		}
	}

	@Override
	public String toString() {
		return "Schueler [name=" + name + ", vorname=" + vorname + "]";
	}

	

	
	
	

}
