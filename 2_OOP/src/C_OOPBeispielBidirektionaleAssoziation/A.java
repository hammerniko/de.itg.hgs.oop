package C_OOPBeispielBidirektionaleAssoziation;

//Minimalbeispiel f?r
//bidirektionale Assoziation
// --> A kennt B und B kennt A (Objekte der klassen)


public class A {
    
    //Deklaration
    B einB;
    
    //Konstruktor
    public A(){
    	System.out.println("A erzeugt");
        einB = new B(this);
        
        
        System.out.println("A ruft B auf");
        einB.testeB();
        
       
        
        
    }
    
    
    
    public void zeigeMeldung(String meldung){
        System.out.println(meldung);
    }
    

}
