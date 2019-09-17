package C1a_BidirektionaleAssoziation_n_m_;

import java.util.HashSet;
import java.util.Set;

class Person {

	String name;
	String vorname;

	private Set<Addresse> addresses = new HashSet<Addresse>();

	// Hier verwalten wir eine Richtung der Beziehung
	// Person-Address:
	public void addAddress(Addresse address) {
		if (addresses.contains(address))
			return;
		addresses.add(address);
		address.addPerson(this); // die andere Richtung pflegen
	}

	public Person(String name, String vorname) {
		super();
		this.name = name;
		this.vorname = vorname;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", vorname=" + vorname + ", addresses=" + addresses + "]";
	}
	
	

}
