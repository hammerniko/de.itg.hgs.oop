package D3_VererbungZeitschriftUebung;

public class StartKlasse {

	

	public static void main(String[] args) {
		
		
		Versicherung v1 = new Versicherung(99, 155, Versicherung.ZAHLUNG_MONATLICH);
		Versicherung v2 = new HaftpflichtVersicherung(2, 50, Versicherung.ZAHLUNG_MONATLICH, 1000000);
		
		v1.addKunde(new Kunde("Meier", "Max"));
		v2.addKunde(new Kunde("Hummel", "Gerd"));
		v1.addKunde(new Kunde("Huber", "Alois"));
		
		try {
			v1.removeKunde(2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.gc();
		
		
		System.out.println(v1);
		System.out.println(v2);
		
		
		
		


	}

}
