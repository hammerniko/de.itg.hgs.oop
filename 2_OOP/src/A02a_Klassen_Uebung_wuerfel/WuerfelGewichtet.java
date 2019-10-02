package A02a_Klassen_Uebung_wuerfel;

public class WuerfelGewichtet extends Wuerfel {

	int[] gewichte; //Wahscheinlichkeiten der Ziffern 1-6 von 0 - 100(%) als int
	
	public WuerfelGewichtet(int[] gewichte) {
		this.gewichte = gewichte.clone();
	}

}
