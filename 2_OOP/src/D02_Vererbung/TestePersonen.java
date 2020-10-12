package D02_Vererbung;

public class TestePersonen {

	

	public static void main(String[] args) {
		
		Schueler s1 = new Schueler("Muster", "Max");
		Lehrer l1 = new Lehrer("Hammer", "Niko","Hr");
		
		Person[] diePersonen = new Person[2];
		diePersonen[0]=s1;
		diePersonen[1]=l1;
		
		
		
		
		for (int i = 0; i < diePersonen.length; i++) {
			System.out.println(diePersonen[i]);
		}

	}

}
