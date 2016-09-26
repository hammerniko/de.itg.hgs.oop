package A04_OOPErweiterungMit1zuN;

import java.util.Arrays;

public class Schulklasse {
	
	//Konstanten
	public static final int MAXANZAHLSCHUELER = 30;
	
	//Objektattribute
	private String name;
	private String beschreibung;
	
	//Assoziation
	Lehrer derLehrer;
	Schulart dieSchulart;
	Schueler dieSchueler[];
	
	//Verwaltungsmetghoden
	public void linkLehrer(Lehrer l){
		derLehrer = l;
	}
	
	public void unlinkLehrer(){
		derLehrer = null;
	}
	
	public void linkSchulart(Schulart s){
		dieSchulart = s;
	}
	
	public void unlinkSchulart(){
		dieSchulart = null;
	}
	

	
	
	//Konstruktor
	public Schulklasse(String name) {
		this.name = name;
		
		//Klassenteiler ist 30
		dieSchueler = new Schueler[MAXANZAHLSCHUELER];
	}

	//getter und setter
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public Lehrer getDerLehrer() {
		return derLehrer;
	}

	public void setDerLehrer(Lehrer derLehrer) {
		this.derLehrer = derLehrer;
	}

	public Schulart getDieSchulart() {
		return dieSchulart;
	}

	public void setDieSchulart(Schulart dieSchulart) {
		this.dieSchulart = dieSchulart;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void addSchueler(Schueler s){
		int index = 0;
		
		//Suche eine freie Stelle
		for (int i = 0; i < dieSchueler.length; i++) {
			if(dieSchueler[i]==null){
				index = i;
				break;
			}
		}
		
		dieSchueler[index]=s;
		dieSchueler[index].setDieKlasse(this);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Schueler getSchuelerAtIndex(int index){
		Schueler returnValue = null;
		
		if(dieSchueler[index]!=null){
			returnValue = dieSchueler[index];
		}
		
		return returnValue; 
		
	}
	
	public void removeSchueler(int index){
		dieSchueler[index]=null;
	}
	
	public void removeSchueler(Schueler s){
		for (int i = 0; i < dieSchueler.length; i++) {
			if(dieSchueler[i]==s){
				dieSchueler[i]=null;
				
			}
		}
		
		
	}
	
	
	
	//Delegationsmethode
	public String getNameKlassenlehrer(){
		return derLehrer.getName();
	}

	@Override
	public String toString() {
		return "Schulklasse [name=" + name + ", beschreibung=" + beschreibung
				+ ", derLehrer=" + derLehrer + ", dieSchulart=" + dieSchulart
				+ ", dieSchueler=" + Arrays.toString(dieSchueler) + "]";
	}
	
	
	public Schueler[] gibSchuelerListe(){
		return dieSchueler;
	}

	public void gibAlleSchuelerNamenAus(){
		System.out.println("\nAusgabe aller Schueler der Klasse "+getName());
		System.out.println("-------------------------------------------");
		for (int i = 0; i < dieSchueler.length; i++) {
			if(dieSchueler[i]!=null){
				System.out.println(dieSchueler[i]);
			}
		}
	}
	
}
