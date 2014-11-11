package B_OOPBeispiel3_UnidirektionaleAssoziation1ZuN;


public class StartKlasse {
	
	public static void main(String[] args) {
		
		Verzeichnis v1 = new Verzeichnis();
		Verzeichnis v2 = new Verzeichnis("a");
		Verzeichnis v3 = new Verzeichnis();
						
		Datei d1 = new Datei("Lehrer", "txt");
		Datei d2 = new Datei("Schueler","txt");
		Datei d3 = new Datei("MeinBild","png");
		
		v1.addDatei(d1);
		v1.addDatei(d2);
		v1.addDatei(d3);
		
		
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
	}
}
