package D05_VererbungBeispielFastFood;

public class KuechenMitarbeiter extends Mitarbeiter {
	
	private double kuechenZulage;

	public KuechenMitarbeiter(String name, String vorname) {
		super(name, vorname);
		kuechenZulage = 50;
	}
	
	@Override
	public double berechneGehalt() {
		return super.berechneGehalt()+kuechenZulage;
	}

	@Override
	public String toString() {
		return super.toString()+" kuechenZulage=" + kuechenZulage;
	}
	
	

}
