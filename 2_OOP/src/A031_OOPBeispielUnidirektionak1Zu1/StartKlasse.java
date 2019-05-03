package A031_OOPBeispielUnidirektionak1Zu1;

public class StartKlasse {

	public static void main(String[] args) {
		//Objekte erzeugen
		Gebaeude a = new Gebaeude("A");
		Gebaeude b = new Gebaeude("B");
		
		//Raum kann nur erstellt werden, wenn ein Gebaeude
		//vorhanden ist
		Raum raumTG11_3 = new Raum(30, "307", a);
		
		//Einer Klasse kann das Klassenzimmer auch
		//zu einem späteren Zeitpunkt zugewiesen werden
		//Exisitiert kein Klassenzimmer, wird die Klasse zur Wanderklasse
		Schulklasse tg11_3 = new Schulklasse("TG 11-3");
		tg11_3.linkKlassenzimmer(raumTG11_3);
			
		
		System.out.println(tg11_3);
		
		
		
		

	}

}
