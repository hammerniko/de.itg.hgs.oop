package D01b_VererbungUeberschreibenBeispiel.copy;

public class Angestellter extends Mitarbeiter {
	private double stdLohn = 10.5;
	private double wStd = 38.5;

	@Override
	public double berechneGehalt() {
		double gehalt = stdLohn * wStd * 4;
		return gehalt;
	}

}
