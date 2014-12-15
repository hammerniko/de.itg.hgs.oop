package D042_VererbungZugriffsrechte;

/**
 * Eine Sonderausgabe ist eine spezielle Zeitung, welche 
 * zus�tzlich das Attribut witz enth�lt.
 * 
 * @author hr
 *
 */
public class Sonderausgabe extends Zeitung {

	private String witz;

	public String getWitz() {
		return witz;
	}

	public void setWitz(String witz) {
		this.witz = witz;
	}

	@Override
	public String toString() {
		return "Sonderausgabe [witz=" + witz + "]";
	}

	public Sonderausgabe(Redakteur rd) {
		super(rd);
	}

	@Override
	public void test() {
		System.out.println("Test SA �berschrieben");
	}

	

	
	
	
}
