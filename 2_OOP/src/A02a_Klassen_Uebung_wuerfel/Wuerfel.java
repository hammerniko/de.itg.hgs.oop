package A02a_Klassen_Uebung_wuerfel;

public class Wuerfel {

	private int wert;
	
	public Wuerfel() {
		wert = 0; //noch nicht gewuerfelt
	}
	
	/**
	 * Erzeuge zufällige Zahlen zwischen 1 und 6
	 * @return Zufallszahl zwischen 1 und 6
	 */
	public int gibWuerfelzahl(){
		return (int) (Math.random()*6+1);
	}

}
