package A2_OOPBeispielSchule;


public class ErzeugeLehrerObjekte {

    
    public static void main(String[] args) {
        
        //Objekt aus der Klasse Lehrer
        Lehrer l1 = new Lehrer("Hammer");
        
        System.out.println(l1.getName());
        
        l1.setName("xxx");
        
        System.out.println(l1.getName());
    }

}
