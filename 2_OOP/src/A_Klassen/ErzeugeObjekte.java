package A_Klassen;

import java.util.Date;

public class ErzeugeObjekte {

	public static void main(String[] args) {
		
		//Array von Sch�lerobjekten
		Schueler dieSchueler[] = new Schueler[3];
		
		//erzeugt Sch�lerobjekt
		dieSchueler[0] = new Schueler("Mueller","Sven",new Date(81,0,1));
		dieSchueler[1] = new Schueler("Romanek","Steven");
		dieSchueler[2] = new Schueler("Maier","Max");
		
		dieSchueler[0].setName("M�ller");
		
		
		//Ausgabe aller Sch�ler
		for (int i = 0; i < dieSchueler.length; i++) {
			System.out.println(dieSchueler[i]);
		}
		
		
	}

}
