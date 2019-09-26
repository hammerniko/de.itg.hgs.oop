package A02_Klassen_Uebung_Wetter;

public class Wetterstation {

	// Wetterdaten
	private double niederschlagsmenge;
	private double regenwahscheinlichkeit;
	private int windstarke; // bft 1-12
	private Windrichtung aktuelleWindrichtung;
	private int windrichungInGrad; // 0 = Nord bis 359°

	// id
	public static int anzahlWetterstationen = 0;
	private static int anzahlGeloeschteStationen = 0;
	private int id;

	// Ort
	private double breitenGrad;
	private double laengenGrad;

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
		return breitenGrad;
	}

	public void setBreitenGrad(double breitenGrad) {
		this.breitenGrad = breitenGrad;
	}

	public double getLaengenGrad() {
		return laengenGrad;
	}

	public void setLaengenGrad(double laengenGrad) {
		this.laengenGrad = laengenGrad;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Wetterstation [niederschlagsmenge=" + niederschlagsmenge + ", regenwahscheinlichkeit="
				+ regenwahscheinlichkeit + ", windstarke=" + windstarke + ", aktuelleWindrichtung="
				+ aktuelleWindrichtung + ", windrichungInGrad=" + windrichungInGrad + ", id=" + id + ", breitenGrad="
				+ breitenGrad + ", laengenGrad=" + laengenGrad + "]";
	}

	public Wetterstation(double breitenGrad, double laengenGrad) {
		super();
		this.breitenGrad = breitenGrad;
		this.laengenGrad = laengenGrad;

		// Anzahl und Id
		anzahlWetterstationen++;
		id = anzahlWetterstationen + anzahlGeloeschteStationen;

		// Singen HGS
		breitenGrad = 47.768317;
		laengenGrad = 8.8336063;

		aktuelleWindrichtung = null;
		windrichungInGrad = 0;

		windstarke = 0;
		regenwahscheinlichkeit = 0;
	}

}

enum Windrichtung {

	Nord, Sued, West, Ost, NordOst, NordWest, SuedOst, SuedWest;

}
