package C_OOPBeispielBidirektionaleAssoziation;

public class Steuerung {
    //Attribut f?r die Assoziation von dieSteuerung auf dieGui
    Gui dieGui;
    
    //Der Konstruktor erwartet beim Aufruf ein
    //Objekt der Klasse Gui
    public Steuerung(Gui eineGui){
        //Das ?bergebenen Gui-Objekt
        //wird dem eigenen Gui-Zeiger
        //zugewiesen
        //Ab diesem Zeitpunkt kennt auch dieSteuerung
        //dieGui
        dieGui = eineGui;
    }
    
    //Methode welche eine Botschaft an
    //dieGui sendet
    public void steuerungsTestMethode(){
        
    	//Ein l?nger dauernder Prozess wird angestossen
    	System.out.println("Methode in der Steuerung");
        
        
        
        dieGui.aktualisiereStatus("Steuerung angesprochen");
   }

}
