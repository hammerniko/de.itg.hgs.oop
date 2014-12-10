package D02_VererbungErweitert;
//Oberklasse
public abstract class Person {

	private Parkplatz derParkplatz;
    protected String name;
    protected String vorname;
	
    public Person(String name) {
			this.name = name;
	}
    
    public void test(){
    	System.out.println("test aus Person");
    }
    
    
    
    public void setParkplatz(Parkplatz p){
    	derParkplatz = p;
    }

	@Override
	public String toString() {
		return  name +", "+vorname +" P=" + derParkplatz ;
	}
    
    
    
}
