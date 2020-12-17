package B_OOPBeispiel2_UnidirektionaleAssoziation1ZuN;

public class StartKlasse {

	public static void main(String[] args) {
		//Kunde und Kontos erstellen
		Kunde fritz = new Kunde("Meier","Fritz");		
		
		Konto kontoFritz = new Konto(12345, 100);
		fritz.addKonto(kontoFritz);
		
		//...
		
		Konto konto=fritz.getKonto(12345);
		double saldo = konto.getSaldo();
		
		
		
		//Daten ausgeben
		ausgabe(saldo);
		
		

	}

	private static void ausgabe(double saldo) {
		System.out.println(saldo);
	}

}
