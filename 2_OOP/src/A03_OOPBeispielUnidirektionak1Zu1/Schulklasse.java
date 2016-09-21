package A03_OOPBeispielUnidirektionak1Zu1;

public class Schulklasse {
	
	//objektattribute
	private String name;
	private String beschreibung;
	
	//Assoziation
	Lehrer derLehrer;
	Schulart dieSchulart;
	
	//Verwaltungsmetghoden
	public void linkLehrer(Lehrer l){
		derLehrer = l;
	}
	
	public void unlinkLehrer(){
		derLehrer = null;
	}
	
	public void linkSchulart(Schulart s){
		dieSchulart = s;
	}
	
	public void unlinkSchulart(){
		dieSchulart = null;
	}
	

	
	
	//Konstruktor
	public Schulklasse(String name) {
		this.name = name;
	}

	//getter und setter
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public Lehrer getDerLehrer() {
		return derLehrer;
	}

	public void setDerLehrer(Lehrer derLehrer) {
		this.derLehrer = derLehrer;
	}

	public Schulart getDieSchulart() {
		return dieSchulart;
	}

	public void setDieSchulart(Schulart dieSchulart) {
		this.dieSchulart = dieSchulart;
	}
	
	
	
	
	//Delegationsmethode
	public String getNameKlassenlehrer(){
		return derLehrer.getName();
	}
	
	
	@Override
	public String toString() {
		return "Schulklasse [name=" + name + ", beschreibung=" + beschreibung
				+ ", derLehrer=" + derLehrer + ", dieSchulart=" + dieSchulart
				+ "]";
	}


}
