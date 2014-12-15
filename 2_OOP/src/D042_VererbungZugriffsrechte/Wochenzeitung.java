package D042_VererbungZugriffsrechte;

public class Wochenzeitung extends Zeitung {

	private String schlagzeile;
	
	
	public Wochenzeitung(Redakteur rd) {
		super(rd);
		schlagzeile = "Standardschlagzeile Wochenzeitung";
	}

	@Override
	public void test() {
		System.out.println("Test Wochenzeitung");

	}
	
	public String getSchlagzeile(){
		return schlagzeile;
	}
	
	public void setSchlagzeile(String schlagzeile){
		this.schlagzeile=schlagzeile;
	}

}
