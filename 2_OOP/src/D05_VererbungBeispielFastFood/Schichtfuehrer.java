package D05_VererbungBeispielFastFood;

public class Schichtfuehrer extends Mitarbeiter {
	
	private double schichtzulage;

	public Schichtfuehrer(String name, String vorname) {
		super(name, vorname);
		schichtzulage = 100;
	}
	
	@Override
	public double berechneGehalt() {
		
		
		// TODO Auto-generated method stub
		return super.berechneGehalt()+schichtzulage;
		
		
		
	}
	
	
	@Override
	public String toString() {
		return super.toString()+" Schichtzulage:"+schichtzulage;
	}

}
