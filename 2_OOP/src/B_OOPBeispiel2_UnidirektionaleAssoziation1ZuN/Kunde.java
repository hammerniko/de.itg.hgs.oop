package B_OOPBeispiel2_UnidirektionaleAssoziation1ZuN;

import java.util.ArrayList;
import java.util.Vector;

public class Kunde {
	
	private String name;
	private String vorname;
	
	//Keklaration für die Aussoziation 1zuN
	Vector<Konto> dieKonten;
	
	public Kunde(String name, String vorname){
		this.name = name;
		this.vorname = vorname;
		dieKonten = new Vector<Konto>();	
	}
	
	
	
	public Konto getKonto(int kontoNr){
		
		for (int i = 0; i < dieKonten.size(); i++) {
			Konto k = dieKonten.elementAt(i);
			if(kontoNr == k.getKontoNr()){
				return dieKonten.elementAt(i);
			}
			k=null;
		}
		
		
		
		//Kein Konto gefunden -> Fehler
		return null;
	}
	
	//Delegationsmethode
	public void addKonto(Konto konto){
		dieKonten.add(konto);
	}
	
	public void removeKonto(int kontoNr){
		for (int i = 0; i < dieKonten.size(); i++) {
			Konto k = dieKonten.elementAt(i);
			if(kontoNr == k.getKontoNr()){
				dieKonten.remove(i);
			}
			k=null;
		}
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getVorname() {
		return vorname;
	}


	public void setVorname(String vorname) {
		this.vorname = vorname;
	}


	@Override
	public String toString() {
		return "Kunde2 [name=" + name + ", vorname=" + vorname + ", dieKonten="
				+ dieKonten + "]";
	}
	
	

}
