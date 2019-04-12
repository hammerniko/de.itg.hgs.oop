package D06VererbungMitAssoziationZeitung;

public abstract class Zeitung {
	
	protected String titel;
	public static final String STANDARD_TITEL = "Bergnachrichten"; 
	
	public Zeitung() {
		titel = STANDARD_TITEL;
	}

	@Override
	public String toString() {
		return "Zeitung [titel=" + titel + "]";
	}
	
	

}
