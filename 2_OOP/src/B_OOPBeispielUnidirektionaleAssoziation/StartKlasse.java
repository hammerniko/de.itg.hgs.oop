package B_OOPBeispielUnidirektionaleAssoziation;

public class StartKlasse {

  
    public static void main(String[] args) {
        //Erzeugen der Objekte
        Schueler s1 = new Schueler("Mike","Mueller");
        Schulklasse tg113 = new Schulklasse("TG11-3");
        
        //Setzen einer Assoziation
        s1.setSchulklasse(tg113);
        
        System.out.println(s1);

    }

}
