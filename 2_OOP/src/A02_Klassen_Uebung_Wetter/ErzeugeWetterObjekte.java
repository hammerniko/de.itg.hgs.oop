package A02_Klassen_Uebung_Wetter;


public class ErzeugeWetterObjekte {

    
    public static void main(String[] args) {
        
       Wetter wetterliste[] = new Wetter[5];
        
       
       erstelleObjekte(wetterliste);
       ausgabeObjekte(wetterliste);
       modifiziereObjekte(wetterliste);
       ausgabeObjekte(wetterliste); 

    }

	private static void ausgabeObjekte(Wetter[] wetterliste) {
		for (int i = 0; i < wetterliste.length; i++) {
			System.out.println(wetterliste[i]);
		}
	}
	
	private static void modifiziereObjekte(Wetter[] wetterliste) {
		wetterliste[3]=null;
		System.gc();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("modifiziert===============================");
	}

	private static void erstelleObjekte(Wetter[] wetterliste) {
		wetterliste[0] = new Wetter("Aach",23);
		   wetterliste[1] = new Wetter("Aachen",23,100);
		   wetterliste[2] = new Wetter("Köln",20,20,70,Wetter.NORD);
		   wetterliste[3] = new Wetter("Hamburg",18,10,90,Wetter.OST,3);
		   wetterliste[4] = new Wetter("Hannover",19);
	}

}
