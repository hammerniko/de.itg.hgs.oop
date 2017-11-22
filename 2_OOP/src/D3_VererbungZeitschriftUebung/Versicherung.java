package D3_VererbungZeitschriftUebung;
import java.util.ArrayList;

public class Versicherung {
	
	//Assoziation auf Kundencontainer dyn.
	ArrayList<Kunde> dieKunden;
		
	//Attribute
	int versicherungsNr;
	double monatsRate;
	int zahlungszyklus;

		
	public static final int ZAHLUNG_MONATLICH = 0;
	public static final int ZAHLUNG_QUARTAL = 1;
	public static final int ZAHLUNG_HALBJAHR = 2;
	public static final int ZAHLUNG_JAHR = 3;
	
	
	
	public Versicherung(int versicherungsNr, double monatsRate, int zahlungszyklus) {
		super();
		this.versicherungsNr = versicherungsNr;
		this.monatsRate = monatsRate;
		this.zahlungszyklus = zahlungszyklus;
		
		dieKunden = new ArrayList<Kunde>();
	}
	
	
	//Verwaltungsmethoden
	
	//Hinzufügen eines Kunden
	public void addKunde(Kunde k) {
		
		dieKunden.add(k);
		
		
	}
	
	
	
	//Entfernen eines Kunden
	public void removeKunde(Kunde k) {
		
		dieKunden.remove(k);
		k = null;
		
	}
	
	public void removeKunde(int kundenNummer) throws Exception {
		
		Kunde kunde;
		
		for (int i = 0; i <dieKunden.size(); i++) {
			
			kunde = dieKunden.get(i);
			
			if(kunde.getKdNr()==kundenNummer) {
				dieKunden.remove(kunde);
				
			}
			
			
		}
		
		
		
		
		
		
	}
	
	
	
	//Auslesen eines Kunden
	public Kunde getKunde(int kundenNummer) throws Exception{
		
		Kunde kunde;
		
		for (int i = 0; i <dieKunden.size(); i++) {
			
			kunde = dieKunden.get(i);
			
			if(kunde.getKdNr()==kundenNummer) {
				return kunde;
			}
			
			
		}
		
		
		throw new KundeNotFoundException();
		
		
		
		
		
		
	}


	@Override
	public String toString() {
		return "Versicherung [dieKunden=" + dieKunden + ", versicherungsNr=" + versicherungsNr + ", monatsRate="
				+ monatsRate + ", zahlungszyklus=" + zahlungszyklus + "]";
	}
	

	
	
	

}
