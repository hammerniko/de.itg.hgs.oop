package A03_OOPBeispielUnidirektionak1Zu1;

public class StartKlasse {

	public static void main(String[] args) {
		
		//Objekte erzeugen
		Lehrer hr = new Lehrer("Hammer", "hr");
		Schulart gym = new Schulart("Gymnasium");
		Schulklasse tg123 = new Schulklasse("TG12-3");
		
		//Assoziation herstellen
		tg123.linkLehrer(hr);
		tg123.linkSchulart(gym);
		
		//Szenario Tg123 gibt Namen des Lehrers auf
		//der Konsole aus
		System.out.println(tg123.getNameKlassenlehrer());
		
		
				
		//Testausgaben
		testausgabe(hr, gym, tg123);
		
		tg123.unlinkLehrer();
		tg123.unlinkSchulart();
		
		testausgabe(hr, gym, tg123);
		
	}

	private static void testausgabe(Lehrer hr, Schulart gym, Schulklasse tg123) {
		System.out.println("------------------------------");
		System.out.println(hr);
		System.out.println(gym);
		System.out.println(tg123);
		System.out.println("------------------------------");
	}

}
