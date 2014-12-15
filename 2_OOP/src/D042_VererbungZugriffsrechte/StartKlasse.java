package D042_VererbungZugriffsrechte;

public class StartKlasse {
	
	public static void main(String[] args){
		Sonderausgabe meineSonderausgabe = new Sonderausgabe(new Redakteur());
		meineSonderausgabe.test();
		
		meineSonderausgabe.derRedakteur.getName();
		
	}
	
	
	
	

}
