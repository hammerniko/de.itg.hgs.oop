package D06VererbungMitAssoziationZeitung;

import java.util.Date;

public class Auftrittsnachricht extends KuenstlerNachricht {

	private Date begin;
	private Date end;
	
	public Auftrittsnachricht(String titel, String nachricht, String name, Date aDatum, Date begin, Date end) {
		super(titel, nachricht, name, aDatum);
		
	}

	@Override
	public String toString() {
		return "Auftrittsnachricht [begin=" + begin + ", end=" + end ;
	}
	
	

}
