package D2_Uebung_kfz;

public class Sekretaerin extends Mitarbeiter {

	private double bueroZulage;
	
	
	public double getBueroZulage() {
		return bueroZulage;
	}


	public void setBueroZulage(double bueroZulage) {
		this.bueroZulage = bueroZulage;
	}


	public Sekretaerin(String name, String vorname, double stundenlohn, double stundenProWoche, double bueroZulage) {
		super(name, vorname, stundenlohn, stundenProWoche);
		this.bueroZulage = bueroZulage;
	}
	
	
	@Override
	public double berechneGehalt() {
		// TODO Auto-generated method stub
		return super.berechneGehalt()+bueroZulage;
	}

}
