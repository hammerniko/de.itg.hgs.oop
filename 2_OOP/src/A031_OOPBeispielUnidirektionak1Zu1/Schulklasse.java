package A031_OOPBeispielUnidirektionak1Zu1;

public class Schulklasse {
	
	private String name;
	private Raum dasKlassenzimmer;

	public Schulklasse(String name) {
		this.name = name;
	}

	public void linkKlassenzimmer(Raum klZimmer){
		dasKlassenzimmer = klZimmer;
	}
	
	public void unlinkKlassenzimmer() {
		dasKlassenzimmer = null;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public Raum getDasKlassenzimmer() {
		return dasKlassenzimmer;
	}

	

	@Override
	public String toString() {
		return "Schulklasse [name=" + name + ", dasKlassenzimmer=" + dasKlassenzimmer + "]";
	}

	
	
	

}
