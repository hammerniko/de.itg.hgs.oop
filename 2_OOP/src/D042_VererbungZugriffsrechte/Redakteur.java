package D042_VererbungZugriffsrechte;

/**
 * Der Redakteur einer ZEitung hat mehr als ein eigenes Attribut und
 * wird deshalb als eigene Klasse implementiert.
 * 
 * @author hr
 *
 */
public class Redakteur {
	
	private String name;
	protected int redakteurNr;

	/**
	 * Konstruktor. Um einen Redakteur zu erstellen, muss
	 * mindestens der Name bekannt sein.
	 * Die redakteurNr dient nur zur Demonstration. Da sie Protectet ist,
	 * kann ein Objekt der Klasse Zeitung nicht drauf zugreifen.
	 * @param strName
	 */
	public Redakteur(String strName) {
		name = strName;
		redakteurNr = 1;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Redakteur [name=" + name + ", redakteurNr=" + redakteurNr + "]";
	}

	
	
}
