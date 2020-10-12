package D02_Vererbung;

public class Lehrer extends Person {
	
	
	private String kuerzel;
	

	public Lehrer(String name, String vorname, String kuerzel) {
		super(name, vorname);
		
		this.kuerzel = kuerzel;

	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" kuerzel:"+kuerzel;
	}

}
