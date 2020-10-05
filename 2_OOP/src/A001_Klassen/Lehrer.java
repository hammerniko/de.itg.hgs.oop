package A001_Klassen;

import java.util.Arrays;

public class Lehrer {
	
	private String name;
	private String vorname;
	private char[] kuerzel;
	
	public Lehrer(String name, String vorname) {
		super();
		this.name = name;
		this.vorname = vorname;
		kuerzel = null;
	}

	public Lehrer(String name, String vorname, char[] kuerzel) {
		super();
		this.name = name;
		this.vorname = vorname;
		setKuerzel(kuerzel);
	}

	public char[] getKuerzel() {
		return kuerzel;
	}

	public void setKuerzel(char[] kuerzel) {
		
		//Wenn Char Array max. 2 Zeichen hat
		if(kuerzel.length<=2) {
			this.kuerzel = kuerzel;
		}
		
		
	}

	public String getName() {
		return name;
	}

	public String getVorname() {
		return vorname;
	}

	@Override
	public String toString() {
		return "Lehrer [name=" + name + ", vorname=" + vorname + ", kuerzel=" + Arrays.toString(kuerzel) + "]";
	}
	
	
	
	

}
