package D01_Vererbung;

public class Lehrer extends Person {
    
	protected String kuerzel;
  
	/**
	 * Konstruktor muss mindestens mit dem Uebergabeparameter
	 * String name erstellt werden, da die Klasse von Person erbt
	 * @param name
	 * @param kuerzel
	 */
    public Lehrer(String name, String kuerzel) {
    	//Ruft in der Oberklasse Person den Konstruktor
    	//mit dem Uebergabeparameter vom Datentyp String auf
    	super(name); //muss erste Anweisung sein
		
		this.kuerzel = kuerzel;
		
	}

	@Override
	public String toString() {
		String str = super.toString();
		str = str + " kuerzel=" + kuerzel;
		return str;
	}
	
	public void test(){
		System.out.println("Test aus Lehrer");
	}

	

}
