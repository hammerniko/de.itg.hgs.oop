package D02_VererbungErweitert;

import java.util.Date;

public class Vertrauenslehrer extends Lehrer {
	
	//derzeit eine Spechstunde pro Woche
	private Date sprechstunde;

	public Date getSprechstunde() {
		return sprechstunde;
	}

	public void setSprechstunde(Date sprechstunde) {
		this.sprechstunde = sprechstunde;
	}

	public Vertrauenslehrer(String name, String kuerzel) {
		super(name, kuerzel);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		String str = super.toString();
		str = str + "Vertauenslehrer [sprechstunde=" + sprechstunde + "]";
		return str;
	}
	
	

}
