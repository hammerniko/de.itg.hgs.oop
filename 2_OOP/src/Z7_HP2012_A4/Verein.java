package Z7_HP2012_A4;

import java.util.ArrayList;
import java.util.Iterator;

public class Verein {
	
	private ArrayList<Person> dasMitglied;
	
	public Verein() {
		dasMitglied = new ArrayList<Person>();
	}
	
	public void addMitglied(Person person){
		dasMitglied.add(person);
	}
	
	public void removeMitglied(String name){
		dasMitglied.remove(name);
	}

	public void alleVorstellen() {
		
		for (Iterator iterator = dasMitglied.iterator(); iterator.hasNext();) {
			Person person = (Person) iterator.next();
			person.vorstellen();
		}
		
		
	}
	
	
 
}
