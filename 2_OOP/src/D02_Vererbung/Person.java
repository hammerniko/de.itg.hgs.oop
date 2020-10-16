package D02_Vererbung;

public class Person {
	
	private String name;
	private String vorname;
	
	
	public Person(String name, String vorname) {
		this.name = name;
		this.vorname = vorname;
	}


	public String getName() {
		return name;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+" "+vorname;
	}
	
	
	
	
	
	

}
