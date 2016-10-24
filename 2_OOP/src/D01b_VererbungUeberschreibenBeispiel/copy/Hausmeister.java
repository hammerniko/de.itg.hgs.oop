package D01b_VererbungUeberschreibenBeispiel.copy;

public class Hausmeister extends Angestellter {
	private int zulagen = 400;

	@Override
	public double berechneGehalt() {
		return super.berechneGehalt() + zulagen;
	}

}
