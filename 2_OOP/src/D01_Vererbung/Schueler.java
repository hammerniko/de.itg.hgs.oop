package D01_Vererbung;

public class Schueler extends Person {

	private boolean istKlassensprecher;
	
	public Schueler(String name) {
		super(name);
		istKlassensprecher = false;
	}

	@Override
	public String toString() {
		String str = super.toString();
		str = str +  " KlSpr:"+istKlassensprecher;
		
		return str;
	}

	@Override
	public void test(int wert) {
		
		
		System.out.println("test in Schueler"+(wert*2));
	}
	
	
	

}
