package D01a_VererbungUeberschreibenBeispiel;

public class Hausmeister extends Angestellter {
	private int zulagen = 400;

	@Override
	public double berechneGehalt() {
		return super.berechneGehalt() + zulagen;
	}

}
