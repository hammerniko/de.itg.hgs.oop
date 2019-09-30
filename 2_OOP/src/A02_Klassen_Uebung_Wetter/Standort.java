package A02_Klassen_Uebung_Wetter;

public class Standort {
	
	private String name;
	private double breitenGrad;
	private double laengenGrad;
	
	public Standort(String name, double breitenGrad, double laengenGrad) {
		super();
		this.name = name;
		this.breitenGrad = breitenGrad;
		this.laengenGrad = laengenGrad;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Standort [name=" + name + ", breitenGrad=" + breitenGrad + ", laengenGrad=" + laengenGrad + "]";
	}

	
	
	
	
	

}
