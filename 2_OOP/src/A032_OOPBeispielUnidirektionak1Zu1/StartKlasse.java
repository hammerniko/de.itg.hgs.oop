package A032_OOPBeispielUnidirektionak1Zu1;

public class StartKlasse {

	public static void main(String[] args) {
		
		//Objekte
		Fahrer f = new Fahrer();
		Auto a = new Auto();
		
		//Assoziation setzen
		f.linkAuto(a);
		
		//Testen der Assoziation
		f.test();
		
		
		f=null;
		a=null;
		
		

	}

}
