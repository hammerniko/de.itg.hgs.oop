package A02a_Klassen_Uebung_wuerfel;

public class StartKlasse {


	public static void main(String[] args) {
		
		int[] anzahlWuerfe = new int[6];
		WuerfelGewichtet wg;
		
		try {
			wg = new WuerfelGewichtet(5, 5, 5, 5, 40, 40);
			for (int i = 0; i < 2000; i++) {
				
				switch (wg.gibWuerfelzahl()) {
				case 1: anzahlWuerfe[0]++; break;
				case 2: anzahlWuerfe[1]++; break;
				case 3: anzahlWuerfe[2]++; break;
				case 4: anzahlWuerfe[3]++; break;
				case 5: anzahlWuerfe[4]++; break;
				case 6: anzahlWuerfe[5]++; break;
				default:
					break;
				}
			
			}
			
		} catch (WuerfelFalschGewichtetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int j = 0; j < anzahlWuerfe.length; j++) {
			System.out.println("Wert:"+(j+1)+" "+anzahlWuerfe[j]+" mal geworfen");
		}
		
		
		
		
		

	}

}
