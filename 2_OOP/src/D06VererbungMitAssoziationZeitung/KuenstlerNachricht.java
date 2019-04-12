package D06VererbungMitAssoziationZeitung;

import java.util.Date;

public class KuenstlerNachricht extends Nachricht {

	private String name;
	private Date auftrittsdatum;
	private double eintrittspreis;
	
	
	
	
	public KuenstlerNachricht(String titel, String nachricht, String name, Date aDatum) {
		super(titel, nachricht);
		
		auftrittsdatum = aDatum;
		this.name = name;
		eintrittspreis = 0;
	}




	@Override
	public String toString() {
		return "KuenstlerNachricht [name=" + name + ", auftrittsdatum=" + auftrittsdatum + ", eintrittspreis="
				+ eintrittspreis + "]";
	}

	

}
