package D2_Uebung_kfz;

public class TesteMitarbeiter {

	public static void main(String[] args) {
		
		 Mitarbeiter[] dieMitarbeiter = new Mitarbeiter[5];
		 Sekretaerin moni = new Sekretaerin("Meier","Moni",15,30,152);
		 KfzMechaniker dirk = new KfzMechaniker("Dirty", "Dirk", 20, 40);
		 dirk.setUeberStundenAmWochenende(90);
		 dirk.setUeberstunden(60);
		
		 dieMitarbeiter[0] = moni;
		 dieMitarbeiter[1] = dirk;
		 
		 
		 //Schleife über alle Mitarbeiter
		 for (int i = 0; i < 5; i++) {
			System.out.println(dieMitarbeiter[i]);
		}
		 
		 
		 
	}

}
