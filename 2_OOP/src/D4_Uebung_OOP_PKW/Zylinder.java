package D4_Uebung_OOP_PKW;

public class Zylinder {
	
	private int durchmesser;
	private int hub;

	public Zylinder(int durchmesser, int hub) {
		this.durchmesser = durchmesser;
		this.hub = hub;
		
	}

	public int getDurchmesser() {
		return durchmesser;
	}

	public void setDurchmesser(int durchmesser) {
		this.durchmesser = durchmesser;
	}

	public int getHub() {
		return hub;
	}

	public void setHub(int hub) {
		this.hub = hub;
	}
	
	public int getHubraumZylinder() {
		return hub * (int) ((durchmesser / 2) * (durchmesser / 2) * Math.PI);
	}
	
	
	
}
