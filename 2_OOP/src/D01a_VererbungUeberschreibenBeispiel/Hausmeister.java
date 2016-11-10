package D01a_VererbungUeberschreibenBeispiel;

public class Hausmeister extends Angestellter {
	public Hausmeister(String name, String vorname) {
		super(name, vorname);
		// TODO Auto-generated constructor stub
	}

	private int zulagen = 400;

	@Override
	public double berechneGehalt() {
		return super.berechneGehalt() + zulagen;
	}

}
