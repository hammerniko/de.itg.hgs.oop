package C1a_BidirektionaleAssoziation_n_m_;

import java.util.HashSet;
import java.util.Set;

class Addresse {

	String strasse;
	String hausnummer;

	private Set<Person> people = new HashSet<Person>();

	// Hier verwalten wir eine Richtung der Beziehung
	// Person-Address:
	public void addPerson(Person person) {
		if (people.contains(person))
			return;
		people.add(person);
		person.addAddress(this); // die andere Richtung pflegen
	}

	public Addresse(String strasse, String hausnummer) {
		super();
		this.strasse = strasse;
		this.hausnummer = hausnummer;
	}

	@Override
	public String toString() {
		return "Address [strasse=" + strasse + ", hausnummer=" + hausnummer + "]";
	}

	public Set<Person> getPeople() {
		return people;
	}

	
	

	
	
	

}