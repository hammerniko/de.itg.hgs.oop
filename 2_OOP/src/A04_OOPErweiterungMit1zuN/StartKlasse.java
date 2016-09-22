package A04_OOPErweiterungMit1zuN;

public class StartKlasse {

	public static void main(String[] args) {
		
		//Objekte erzeugen
		Lehrer hr = new Lehrer("Hammer", "hr");
		Schulart gym = new Schulart("Gymnasium");
		Schulklasse tg123 = new Schulklasse("TG12-3");
		Schulklasse tg124 = new Schulklasse("TG12-4");
		Schueler s1 = new Schueler("Max", "Meier");
		Schueler s2 = new Schueler("Marco", "Reus");
		Schueler s3 = new Schueler("Thomas", "Thiel");
				
		//Assoziation herstellen
		tg123.linkLehrer(hr);
		tg123.linkSchulart(gym);
		
		//Schüler einer Klasse hinzufügen
		tg123.addSchueler(s1);
		tg123.addSchueler(s2);
		tg123.addSchueler(s3);
		
		//Einem Schüler eine neue Klasse zuweisen
		s1.setDieKlasse(tg124);
		
		
		
		//Szenario Tg123 gibt Namen des Lehrers auf
		//der Konsole aus
		System.out.println(tg123.getNameKlassenlehrer());
		
		//Zugriff von der Klasse auf Schuelerdaten
		tg123.gibAlleSchuelerNamenAus();
		tg124.gibAlleSchuelerNamenAus();
		
		//Zugrif vom Schueler auf Klassendaten
		System.out.println("Klasse:"+s1.getDieKlasse());
		
		
	}

	private static void testausgabe(Lehrer hr, Schulart gym, Schulklasse tg123) {
		System.out.println("------------------------------");
		System.out.println(hr);
		System.out.println(gym);
		System.out.println(tg123);
		System.out.println("------------------------------");
	}

}
