package B_OOPBeispielUnidirektionaleAssoziation1;

public class StartKlasse {

	public static void main(String[] args) {
		
		//Objekte für Szenario erzeugen
		Schulklasse tg123 = new Schulklasse("TG Informationstechnik JS1", "TG12-3");
		Schueler s1 = new Schueler("Mueller","Det", tg123);
		
		//Szenario
		String k = s1.getSchulklasse();
		
		s1.ausgabeText(k);

	}

}
