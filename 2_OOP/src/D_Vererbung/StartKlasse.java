package D_Vererbung;

public class StartKlasse {

   
    public static void main(String[] args) {
       
    	//Objekte erzeugen
    	Person diePersonen[] = new Person[3];
    	
    	
        Parkplatz p1 = new Parkplatz();
        
        diePersonen[0] = new Schueler("Borges");
        diePersonen[1] = new Schueler("Nothe");
        diePersonen[2] = new Lehrer("Grobian", "Gr");
        
        //Assoziation setzen für ein LehrerObjekt
        diePersonen[2].setParkplatz(p1);
        
        //Ausgabe über toString Methode
        //und Aufruf der Methode Test -> Polymorphie
        for (int i = 0;  i < diePersonen.length; i++) {
        	System.out.println(diePersonen[i]);
			diePersonen[i].test();
		}
        
        
    }
    
}