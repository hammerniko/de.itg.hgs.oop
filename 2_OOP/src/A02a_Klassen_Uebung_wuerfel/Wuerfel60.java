package A02a_Klassen_Uebung_wuerfel;

public class Wuerfel60 extends Wuerfel{

	private int z;
	private int wuerfelZahl;
	
	public Wuerfel60() {
		z=0;
		wuerfelZahl = 0;
		
	}
	
	@Override
	public int gibWuerfelzahl() {
		int wuerfelZahl;
		
		//erzeuge Zufallszahl von 0..100
		int z = (int) (Math.random()*100);
		
		
		if(z>40){
			//60% soll eine 6 zurückgegeben werden
			wuerfelZahl = 6;
		}
		else{
			//die anderen 40% liegen zwischen 1..5
			wuerfelZahl = (int) (Math.random()*5+1);
		}
		
		return wuerfelZahl;
		
	}
	
	

}
