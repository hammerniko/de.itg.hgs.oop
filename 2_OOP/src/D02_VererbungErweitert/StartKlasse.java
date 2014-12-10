package D02_VererbungErweitert;

import java.util.Date;

public class StartKlasse {

   
    public static void main(String[] args) {
       
    	//Objekte erzeugen
    	Person diePersonen[] = new Person[4];
        Parkplatz p1 = new Parkplatz();
        diePersonen[0] = new Schueler("Borges");
        diePersonen[1] = new Schueler("Nothe");
        diePersonen[2] = new Lehrer("Grobian", "Gr");
        diePersonen[3] = new Vertrauenslehrer("Liebling", "lb");
       
        //Zugriff auf spezielle Methode einer Unterklasse
        //wenn das Objekt in einem Container einer Oberklasse liegt.
        Vertrauenslehrer vl = (Vertrauenslehrer) diePersonen[3];
        vl.setSprechstunde(new Date(2014,0,11,15,30));
        
        //Einer Person einen Parkplatz zuweisen
        diePersonen[2].setParkplatz(p1);
        
        //Ausgabe über toString Methode
        for (int i = 0;  i < diePersonen.length; i++) {
        	System.out.println(diePersonen[i]);
		}
     }
    
}