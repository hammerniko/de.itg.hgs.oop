package C1_BidirektionaleAssoziation_n_m_DAO_Pattern;

public class Startklasse {

	public static void main(String[] args) {
		Schueler moritz = new Schueler("Halter", "Moritz");
		Schueler fabian = new Schueler("Karler", "Fabian");

		Fach e = new Fach("Englisch", "E");
		Fach m = new Fach("Mathematik", "M");

		Bewertung[] noten = new Bewertung[3];
		noten[0] = new Bewertung(moritz.getIdSchueler(), e.getIdFach(), 1.3, 2);
		noten[1] = new Bewertung(moritz.getIdSchueler(), m.getIdFach(), 2.4, 4);
		noten[2] = new Bewertung(fabian.getIdSchueler(), m.getIdFach(), 2.2, 4);

		for (int i = 0; i < noten.length; i++) {
			System.out.println(noten[i]);
		}

	}
}
