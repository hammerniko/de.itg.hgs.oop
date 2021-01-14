package D4_Uebung_OOP_PKW;

public class Startklasse {

	public static void main(String[] args) {
		//Pkw erstellen
		Pkw pkw1 = new Pkw();
		pkw1.addEinzelteil(new Motor("BMW B58", 6));
		pkw1.addEinzelteil(new Rad("RadVoLi",19,225)); // VoLi
		pkw1.addEinzelteil(new Rad("RadVoRe",19,225)); // VoLi
		pkw1.addEinzelteil(new Rad("RadHiRe",19,255)); // VoLi
		pkw1.addEinzelteil(new Rad("RadHiRe",19,255)); // VoLi
		
		
		//Fahrzeughalter erstellen
		Fahrzeughalter fzh1 = new Fahrzeughalter("Hammer","Nikolai");
		
		//Dem Fahrzeughalter einen Pkw zuordnen
		fzh1.kaufePkw(pkw1);

		
		System.out.println(fzh1);

	}

}
