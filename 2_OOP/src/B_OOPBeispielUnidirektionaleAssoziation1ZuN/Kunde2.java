package B_OOPBeispielUnidirektionaleAssoziation1ZuN;

import java.util.Vector;

public class Kunde2 {
	
	private String name;
	private String vorname;
	
	
	
	//Keklaration für die Aussoziation 1zuN
	Vector<Konto2> dieKonten;
	
	
	public Kunde2(String name, String vorname){
		this.name = name;
		this.vorname = vorname;
		dieKonten = new Vector<Konto2>();
	}
	
	
	public Konto2 getKonto(int pos){
		return dieKonten.elementAt(pos);
	}
	
	public void addKonto(Konto2 konto){
		dieKonten.add(konto);
	}
	
	public void removeKonto(int pos){
		dieKonten.remove(pos);
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
