package D06VererbungMitAssoziationZeitung;

import java.awt.Image;
import java.util.ArrayList;

public class Nachricht {
	
	private int id;
	private static int anzahl=0;
	private String titel;
	private String nachrichtenText;
	private ArrayList<Image> bild;
		

	public Nachricht(String titel, String nachricht) {
		this.titel = titel;
		nachrichtenText = nachricht;
		bild = new ArrayList<Image>();
		
		anzahl++;
		id=anzahl;
	}


	@Override
	public String toString() {
		return "Nachricht [id=" + id + ", titel=" + titel + ", nachrichtenText=" + nachrichtenText + ", bild=" + bild
				+ "]";
	}
	
	

}
