package D01_Vererbung;
//Oberklasse
public class Person {

	private Parkplatz derParkplatz;
    protected String name;
    protected String vorname;
	
    public Person(String name) {
			this.name = name;
	}
    
    public void test(){
    	System.out.println("test aus Person");
    }
    
    //überladene Testmethode
    public void test(int wert){
    	System.out.println("test "+wert+" aus Person");
    }
    
    public void setParkplatz(Parkplatz p){
    	derParkplatz = p;
    }

	@Override
	public String toString() {
		return "Parkplatz=" + derParkplatz + ", name=" + name
				+ ", vorname=" + vorname;
	}
    
    
    
}
