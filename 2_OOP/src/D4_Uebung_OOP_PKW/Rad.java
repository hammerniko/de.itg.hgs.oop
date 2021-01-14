package D4_Uebung_OOP_PKW;

public class Rad extends Einzelteil{

	private int radgroesse; //in Zoll 
	private int breite; //in mm
	
	public Rad(String name) {
		super(name);
		radgroesse = 15;
		breite = 175;
	}
	
	public Rad(String name, int radgroesse, int breite) {
		super(name);
		this.radgroesse = radgroesse;
		this.breite = breite;
	}
	
}
