package D06VererbungMitAssoziationZeitung;

import java.util.Date;

public class Startklasse {

	public static void main(String[] args) {
		Infoblatt ib1 = new Infoblatt();
		Nachricht n1 = new Nachricht("Wintergrillen", "Dieses Jahr findet auf dem Hohentwiel...");
		ib1.addNachricht(n1);
		
		Infoblatt ib2 = new Infoblatt();
		Nachricht n2 = new Nachricht("Wiederholung Wintergrillen", "Weil es so schön war findet auf dem Hohentwiel nochmal...");
		ib2.addNachricht(n2);
		
		Infoblatt ib3 = new Infoblatt();
		KuenstlerNachricht k1 = new KuenstlerNachricht("Der König ist da", "Nach vielen Jahren...", "Joe Cocker", new Date(2019, 7, 25));
		KuenstlerNachricht k2 = new KuenstlerNachricht("Stockacher Musiker", "Trotz Tournee durch Deutschland...", "Glasperlenspiel", new Date(2019, 7, 26));
		ib3.addNachricht(k1);
		ib3.addNachricht(k2);
		
		System.out.println(ib1);
		System.out.println(ib2);
		System.out.println(ib3);
		

	}

}
