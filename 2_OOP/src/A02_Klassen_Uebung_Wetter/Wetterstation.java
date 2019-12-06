package A02_Klassen_Uebung_Wetter;

public class Wetterstation {

	// Klassenattribute
	public static int anzahlWetterstationen = 0;
	private static int anzahlGeloeschteStationen = 0;

	// Objektattribute
	private int id;
	private double niederschlagsmenge;
	private double regenwahscheinlichkeit;
	private int windstarke; // bft 1-12
	private Windrichtung aktuelleWindrichtung;
	private int windrichungInGrad; // 0 = Nord bis 359grad

	//Assoziation
	private Standort derStandort;

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		anzahlWetterstationen--;
		anzahlGeloeschteStationen++;

	}

	public double getNiederschlagsmenge() {
		return niederschlagsmenge;
	}

	public void setNiederschlagsmenge(double niederschlagsmenge) {
		this.niederschlagsmenge = niederschlagsmenge;
	}

	public double getRegenwahscheinlichkeit() {
		return regenwahscheinlichkeit;
	}

	public void setRegenwahscheinlichkeit(double regenwahscheinlichkeit) {
		this.regenwahscheinlichkeit = regenwahscheinlichkeit;
	}

	public int getWindstarke() {
		return windstarke;
	}

	public void setWindstarke(int windstarke) {
		this.windstarke = windstarke;
	}

	public Windrichtung getAktuelleWindrichtung() {
		return aktuelleWindrichtung;
	}

	public void setAktuelleWindrichtung(Windrichtung aktuelleWindrichtung) {
		this.aktuelleWindrichtung = aktuelleWindrichtung;
	}

	public int getWindrichungInGrad() {
		return windrichungInGrad;
	}

	public void setWindrichungInGrad(int windrichungInGrad) {
		this.windrichungInGrad = windrichungInGrad;
	}

	public double getBreitenGrad() {
		return derStandort.getBreitenGrad();
	}

	public void setBreitenGrad(double breitenGrad) {
		derStandort.setBreitenGrad(breitenGrad);
	}

	public double getLaengenGrad() {
		return derStandort.getLaengenGrad();
	}

	public int getId() {
		return id;
	}

	
	

	@Override
	public String toString() {
		return "Wetterstation [id=" + id + ", niederschlagsmenge=" + niederschlagsmenge + ", regenwahscheinlichkeit="
				+ regenwahscheinlichkeit + ", windstarke=" + windstarke + ", aktuelleWindrichtung="
				+ aktuelleWindrichtung + ", windrichungInGrad=" + windrichungInGrad + ", derStandort=" + derStandort
				+ "]";
	}

	public Wetterstation(Standort standort) {
		super();
		derStandort = standort;

		// Anzahl und Id
		anzahlWetterstationen++;
		id = anzahlWetterstationen + anzahlGeloeschteStationen;

		aktuelleWindrichtung = null;
		windrichungInGrad = 0;

		windstarke = 0;
		regenwahscheinlichkeit = 0;
	}

}

enum Windrichtung {

	Nord, Sued, West, Ost, NordOst, NordWest, SuedOst, SuedWest;

}
