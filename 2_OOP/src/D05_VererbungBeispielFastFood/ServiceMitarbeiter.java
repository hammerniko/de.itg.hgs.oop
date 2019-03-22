package D05_VererbungBeispielFastFood;

public class ServiceMitarbeiter extends Mitarbeiter {
	
	private int serviceZulage;

	public ServiceMitarbeiter(String name, String vorname) {
		super(name, vorname);
		serviceZulage = 70;
	}
	
	@Override
	public String toString() {
		return super.toString()+" ServiceZulage:"+serviceZulage;
	}
	
	@Override
	public double berechneGehalt() {
		return super.berechneGehalt()+serviceZulage;
	}
	

}
