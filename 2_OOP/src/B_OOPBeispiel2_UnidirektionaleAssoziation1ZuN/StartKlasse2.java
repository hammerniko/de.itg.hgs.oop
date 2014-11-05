package B_OOPBeispiel2_UnidirektionaleAssoziation1ZuN;

public class StartKlasse2 {

	public static void main(String[] args) {
		//Kunde und Kontos erstellen
		Kunde2 fritz = new Kunde2("Meier","Fritz");
		fritz.addKonto(new Konto2(12345, 100));
		fritz.addKonto(new Konto2(23456, 0));
		fritz.addKonto(new Konto2(5678, 200000));
		
		
		//Konto l?schen
		fritz.removeKonto(1);
		
		//Daten ausgeben
		System.out.println(fritz);
		
		

	}

}
