package A05_OOPBeispielUnidirektionak1Zu1SchulklasseUndRaum;

public class Schulklasse {
	
	private String klassenName;
	
	//Assoziation
	private Raum dasKlassenzimmer;
	

	public Schulklasse(String klassenName) {
		super();
		this.klassenName = klassenName;
	}

	public String getKlassenName() {
		return klassenName;
	}

	public void setKlassenName(String klassenName) {
		this.klassenName = klassenName;
	}
	
	public void linkKlassenzimmer(Raum raum) {
		dasKlassenzimmer = raum;
	}
	
	public void unlinkKlassenzimmer() {
		dasKlassenzimmer = null;
	}

	@Override
	public String toString() {
		return "Schulklasse [klassenName=" + klassenName + ", dasKlassenzimmer=" + dasKlassenzimmer + "]";
	}
	
	
	
	

}
