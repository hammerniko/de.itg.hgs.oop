package Z7_HP2012_A4;

public class Person {
	protected String name;
	
	public Person(String name) {
		this.name  = name;
	}
	
	
	
	public void vorstellen() {
		System.out.println("Person: \t"+name);
	}
	
	public void setName(String pName) {
		name = pName;
	}



	
}
