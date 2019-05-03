package A031_OOPBeispielUnidirektionak1Zu1;

public class Gebaeude {
	
	private String bezeichnung;
	

	public Gebaeude(String bezeichnung) {
		super();
		this.bezeichnung = bezeichnung;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	@Override
	public String toString() {
		return "Gebaeude [bezeichnung=" + bezeichnung + "]";
	}
	
	

}
