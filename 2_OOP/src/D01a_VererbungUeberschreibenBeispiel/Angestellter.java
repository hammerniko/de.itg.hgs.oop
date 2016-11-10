package D01a_VererbungUeberschreibenBeispiel;

public class Angestellter extends Mitarbeiter {
	public Angestellter(String name, String vorname) {
		super(name, vorname);
		// TODO Auto-generated constructor stub
	}

	private double stdLohn = 10.5;
	private double wStd = 38.5;

	@Override
	public double berechneGehalt() {
		double gehalt = stdLohn * wStd * 4;
		return gehalt;
	}

}
