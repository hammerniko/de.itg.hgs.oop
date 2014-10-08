package A02_Klassen_Uebung_Wetter;


public class ErzeugeWetterObjekte {

    
    public static void main(String[] args) {
        
       Wetter wetterliste[] = new Wetter[5];
        
       
       wetterliste[0] = new Wetter("Aach",23);
       wetterliste[1] = new Wetter("Aachen",23,100);
       wetterliste[2] = new Wetter("Köln",20,20,70,Wetter.NORD);
       wetterliste[3] = new Wetter("Hamburg",18,10,90,Wetter.OST,3);
       wetterliste[4] = new Wetter("Hannover",19);
        
       
       
       for (int i = 0; i < wetterliste.length; i++) {
		System.out.println(wetterliste[i]);
	}
        

    }

}
