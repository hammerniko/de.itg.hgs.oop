package B_OOPBeispiel2_UnidirektionaleAssoziation1ZuN;

import java.util.Vector;

public class Kunde {
	
	private String name;
	private String vorname;
	
	
	
	//Keklaration f?r die Aussoziation 1zuN
	Vector<Konto> dieKonten;
	
	
	public Kunde(String name, String vorname){
		this.name = name;
		this.vorname = vorname;
		dieKonten = new Vector<Konto>();
	}
	
	
	public Konto getKonto(int pos){
		return dieKonten.elementAt(pos);
		
	}
	
	public void addKonto(Konto konto){
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
