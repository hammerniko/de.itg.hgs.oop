package D042_VererbungZugriffsrechte;

public class Sonderausgabe extends Zeitung {

	private String witz;
	
	@Override
	public String toString() {
		
		String str = super.toString();
		str = str + witz;
		return str;
	}

	public String getWitz() {
		return witz;
	}

	public void setWitz(String witz) {
		this.witz = witz;
	}

	public Sonderausgabe(Redakteur rd) {
		super(rd);
		

	}

	@Override
	public void test() {
		System.out.println("Test überschrieben");
		
	}

	

	
	
	
}
