package B_OOPBeispielUnidirektionaleAssoziation;

public class StartKlasse {

  
    public static void main(String[] args) {
        //Erzeugen der Objekte
    	Schulklasse tg113 = new Schulklasse("TG11-3");
        Schueler s1 = new Schueler("Mike","Mueller",tg113);
        Schueler s2 = new Schueler("Max","Bohr",tg113);
       
        Schulklasse bktk = new Schulklasse("BKTK");
        bktk.setBeschreibung("Berufskolleg für Technische Kommunikation");
        
        Schueler s3 = new Schueler("Max","Bohr",bktk);
        
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

    }

}
