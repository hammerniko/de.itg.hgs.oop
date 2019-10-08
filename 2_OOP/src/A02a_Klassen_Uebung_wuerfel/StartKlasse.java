package A02a_Klassen_Uebung_wuerfel;

public class StartKlasse {


	public static void main(String[] args) {
		
		Wuerfel w1 = new Wuerfel();
		Wuerfel60 w2 = new Wuerfel60();
		
		w1.gibWuerfelzahl();
		for (int i = 0; i < 200; i++) {
			System.out.println(w2.gibWuerfelzahl());
		}
		
		

	}

}
