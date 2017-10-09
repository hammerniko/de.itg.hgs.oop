package B_OOPBeispielUnidirektionaleAssoziation1;

public class Schulklasse {
	
	private String bezeichnung;
	private String kuerzelStdPlan;
	
	public Schulklasse(String bezeichnung, String kuerzelStdPlan) {
		super();
		this.bezeichnung = bezeichnung;
		this.kuerzelStdPlan = kuerzelStdPlan;
	}

	public String getKuerzelStdPlan() {
		return kuerzelStdPlan;
	}
	
	

}
