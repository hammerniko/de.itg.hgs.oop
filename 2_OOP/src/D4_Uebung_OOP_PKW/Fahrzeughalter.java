package D4_Uebung_OOP_PKW;

public class Fahrzeughalter {
	
	private String name;
	private String vorname;
	
	Pkw  meinPkw;
	
	public Fahrzeughalter(String name, String vorname) {
		this.name = name;
		this.vorname = vorname;
		 
	}
	
	public void kaufePkw(Pkw pkw) {
		meinPkw = pkw;
	}

	@Override
	public String toString() {
		return "Fahrzeughalter [name=" + name + ", vorname=" + vorname + ", meinPkw=" + meinPkw + "]";
	}
	
	
	

}
