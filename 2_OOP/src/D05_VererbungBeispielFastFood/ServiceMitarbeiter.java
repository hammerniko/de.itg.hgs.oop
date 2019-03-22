package D05_VererbungBeispielFastFood;

public class ServiceMitarbeiter extends Mitarbeiter {
	
	private int serviceZulage;

	public ServiceMitarbeiter(String name, String vorname) {
		super(name, vorname);
		serviceZulage = 70;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" ServiceZulage:"+serviceZulage;
	}
	
	@Override
	public double berechneGehalt() {
		// TODO Auto-generated method stub
		return super.berechneGehalt()+serviceZulage;
	}
	

}
