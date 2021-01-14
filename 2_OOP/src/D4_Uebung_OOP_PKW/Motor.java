package D4_Uebung_OOP_PKW;

public class Motor extends Einzelteil{
	
	private Zylinder[] zylinder;
	private int hubraum;
	
	public Motor(String name, int anzahlZylinder) {
		super(name);
		zylinder = new Zylinder[anzahlZylinder];
	}
	
	public void setHubraum(int hubraum) {
		this.hubraum = hubraum;
	}
	
	

	
	
	

}
