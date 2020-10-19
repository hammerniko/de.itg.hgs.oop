package D2_Uebung_kfz;

public abstract class Mitarbeiter {
	
	private String name;
	private String vorname;
	private double stundenlohn;
	private int ueberstunden; //in Minuten
	private double stundenProWoche;
	private double zulage;
	
	public Mitarbeiter(String name, String vorname, double stundenlohn, double stundenProWoche) {
		this.name = name;
		this.vorname = vorname;
		this.stundenlohn = stundenlohn;
		this.stundenProWoche = stundenProWoche;
		this.zulage = 0;
		this.ueberstunden = 0;
	}
	
	
	public double berechneGehalt() {
		
		double ueberstundengeld = ueberstunden / 60 * stundenlohn;
		
		double gehalt = 4 * stundenProWoche * stundenlohn + zulage + ueberstundengeld;
		
		return gehalt;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public double getStundenlohn() {
		return stundenlohn;
	}

	public void setStundenlohn(double stundenlohn) {
		this.stundenlohn = stundenlohn;
	}

	public int getUeberstunden() {
		return ueberstunden;
	}

	public void setUeberstunden(int ueberstunden) {
		this.ueberstunden = ueberstunden;
	}

	public double getStundenProWoche() {
		return stundenProWoche;
	}

	public void setStundenProWoche(double stundenProWoche) {
		this.stundenProWoche = stundenProWoche;
	}

	public double getZulage() {
		return zulage;
	}

	public void setZulage(double zulage) {
		this.zulage = zulage;
	}


	@Override
	public String toString() {
		return "Mitarbeiter [name=" + name + ", vorname=" + vorname + ", stundenlohn=" + stundenlohn + ", ueberstunden="
				+ ueberstunden + ", stundenProWoche=" + stundenProWoche + ", zulage=" + zulage + ", berechneGehalt()="
				+ berechneGehalt() + "]";
	}

	
	
	
	
	
	

	
}
