package D042_VererbungZugriffsrechte;

public class Redakteur {
	
	private String name;
	protected int redakteurNr;

	public Redakteur(String strName) {
		name = strName;
		redakteurNr = 1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Redakteur [name=" + name + ", redakteurNr=" + redakteurNr + "]";
	}

	
	
}
