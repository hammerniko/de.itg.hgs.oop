package C_OOPBeispielBidirektionaleAssoziation;

public class B {
    
    //Deklaration
    A einA;
    
    public B(A dasA){
    	System.out.println("B erzeugt");
        einA = dasA;
        
        
    }
    
    
    public void testeB() {
    	einA.zeigeMeldung("B ruft A auf...");
    }

}
