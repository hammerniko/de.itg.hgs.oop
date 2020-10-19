package D2_Uebung_kfz;

public class KfzMechaniker extends Mitarbeiter{
	
	private int ueberStundenAmWochenende;

	public int getUeberStundenAmWochenende() {
		return ueberStundenAmWochenende;
	}

	public void setUeberStundenAmWochenende(int ueberStundenAmWochenende) {
		this.ueberStundenAmWochenende = ueberStundenAmWochenende;
	}

	public KfzMechaniker(String name, String vorname, double stundenlohn, double stundenProWoche) {
		super(name, vorname, stundenlohn, stundenProWoche);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double berechneGehalt() {
		// TODO Auto-generated method stub
		return super.berechneGehalt()+(2*getStundenlohn()*ueberStundenAmWochenende/60);
	}

	
	
	
	

}
