package C1a_BidirektionaleAssoziation_n_m_;

/**
 * Bidirektionale Assoziation mit m:n Multiplizit�ten
 * ohne eine zus�tzliche Zuordnungsklasse.
 * 
 * Wenn eine Person eine neue Adresse bekommt, 
 * muss darauf geachtet werden, dass auch bei der Adresse
 * die neue Person hinzugef�gt wird.
 * 
 * Umgekehrt kann an einer Adresse eine neue Person einziehen.
 * Hier muss bei der Person ebenfalls die Adresse aktualisiert / hinzugef�gt werden.
 * 
 * @author hr
 *
 */

public class TestMzuN {

	public static void main(String[] args) {
		Person personMax = new Person("Muster", "Max");
		Person personDetlef = new Person("Soost", "Detlef");
		
		Addresse adresseHGS = new Addresse("Uhlandstrasse", "11");
		Addresse adresseHOME = new Addresse("Maximilianstrasse", "8");
		
		personMax.addAddress(adresseHGS);
		personMax.addAddress(adresseHOME);
		
		adresseHOME.addPerson(personDetlef);
		

		System.out.println(adresseHOME.getPeople());
	}

}
