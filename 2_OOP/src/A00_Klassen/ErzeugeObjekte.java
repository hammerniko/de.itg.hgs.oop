package A00_Klassen;

import java.util.Date;

public class ErzeugeObjekte {

	public static void main(String[] args) {
		//XXX
		
		//Array von Sch?lerobjekten anlegen
		Schueler dieSchueler[] = new Schueler[3];
		
		
		//Schuelerobjekt erzeugen und in das Array einf?gen
		dieSchueler[0] = new Schueler("M?ller","Sven");
		dieSchueler[1] = new Schueler("Maier","Max");
		dieSchueler[2] = new Schueler("Brehmer","Steven");
		
		
		//?ndern eines Objektwertes
		dieSchueler[1].setName("Mayer");
		dieSchueler[2].setGebDatum( new Date(89,11,3));
		
		
		//Ausgabe aller Sch?lerobjekte
		for (int i = 0; i < dieSchueler.length; i++) {
			System.out.println(dieSchueler[i]);
		}
		
		
	}

}
