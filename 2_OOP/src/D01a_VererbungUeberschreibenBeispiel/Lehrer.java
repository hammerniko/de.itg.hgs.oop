package D01a_VererbungUeberschreibenBeispiel;

public class Lehrer extends Mitarbeiter {

	public Lehrer(String name, String vorname) {
		super(name, vorname);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double berechneGehalt() {
		return 2500.0;
	}

}
