package D042_VererbungZugriffsrechte;

/**
 * Dieses Beispiel dient der Veranschaulichung der Zugriffsrechte
 * auf geerbte / ueberschriebene Methoden.
 * Es zeigt auch den Zugriff auf spezielle Methoden die nur in den Unterklassen
 * enthalten sind, wenn Objekte dieser Klasse in einem Container mit dem Datentyp
 * einer gemeinsamen Oberklasse zusammengefasst sind.
 * @author hr
 *
 */
public abstract class Zeitung {
	
	

	// Die Zeitung kennt seinen Redakeur
	private Redakteur derRedakteur;

	// Beispielattribut, auf welches die Klasse selbst und erbende
	// Zugriff haben
	protected int id;
	
	private static int anzahlZeitungen = 0;

	public static int getAnzahlZeitungen() {
		return anzahlZeitungen;
	}

	/**
	 * Konstruktor wird ausgef�hrt, auch wenn die Klasse Zeitung abstract ist,
	 * da in den Unterklassen dieser
	 * mit super(rd); aufgerufen wird.
	 * @param rd
	 */
	public Zeitung(Redakteur rd) {

		// Assoziation auf das Objekt der Klasse Redakteur
		derRedakteur = rd;

		// der Wert kann von einem Objekt einer erbenden
		// Klasse direkt wieder ge�ndert werden -> evtl. Sicherheitsrisiko.
		anzahlZeitungen++;
		id = anzahlZeitungen;
	}

	/**
	 * Diese Methode ist ohne Implementierung. Alle erbenden Klassen m�ssen
	 * diese Methode implementieren.
	 * 
	 */
	public abstract void test();

	/**
	 * Delegationsmethode. Ohne diese Delegation m�sste ein Objekt einer
	 * Unterklasse objektname.derRedakteur.getName(); aufrufen. Die ist
	 * un�bersichtlich. Diese Methode erlaubt dagegen den Aufruf
	 * 
	 * @return der Name des Redakteurs
	 */
	public String getRedakteurname() {
		return derRedakteur.getName();
	}

	@Override
	public String toString() {
		return "Zeitung [derRedakteur=" + derRedakteur + ", id=" + id + "]";
	}

}
