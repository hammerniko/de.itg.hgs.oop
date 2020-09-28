package A002_Uebung_Klassen_Projekttage;

import java.util.Date;

public class Projekt {
	
	//Klassenattribut
	private static int anzahlProjekte = 0;
	public static final String[] ORTLISTE = {"Singen","Hilzingen"};
	
	//Objektattribut
	private int id;
	private String name;
	private String beschreibung;
	private Date datumVon;
	private Date datumBis;
	private String material;
	private int ortNr;
	private int minTeilnehmer;
	private int maxTeilnehmer;
	private Date vorbeschrechungAm;
	private String vorbesprechungsraum;
	private String mindestvoraussetzung;
	private Person betreuer;
	
	
	@SuppressWarnings("deprecation")
	public Projekt(String name, Person betreuer) {
		this.name = name;
		this.betreuer = betreuer;
		
		anzahlProjekte++;
		id = anzahlProjekte;
		
		beschreibung = "Hier steht die Beschreibung";
		datumVon = new Date(2020, 10, 25, 8, 30);
		datumBis = new Date(2020, 10, 28, 15, 0);
		
		//....
		
	}
	
	
	

}
