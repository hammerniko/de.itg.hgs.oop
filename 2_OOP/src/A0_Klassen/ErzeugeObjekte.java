package A0_Klassen;

import java.util.Date;

public class ErzeugeObjekte {

	public static void main(String[] args) {
		
		
		//Array von Schülerobjekten anlegen
		Schueler dieSchueler[] = new Schueler[3];
		
		
		//Schuelerobjekt erzeugen und in das Array einfügen
		dieSchueler[0] = new Schueler("Müller","Sven");
		dieSchueler[1] = new Schueler("Maier","Max");
		dieSchueler[2] = new Schueler("Brehmer","Steven");
		
		
		//Ändern eines Objektwertes
		dieSchueler[1].setName("Mayer");
		dieSchueler[2].setGebDatum( new Date(89,11,3));
		
		
		//Ausgabe aller Schülerobjekte
		for (int i = 0; i < dieSchueler.length; i++) {
			System.out.println(dieSchueler[i]);
		}
		
		
	}

}
