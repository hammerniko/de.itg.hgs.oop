package D02_VererbungErweitert;

public class Parkplatz {

	private int id;
	private static int anzahlParkplaetze=0;

	public Parkplatz(){
		anzahlParkplaetze++;
		id=anzahlParkplaetze;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Parkplatz [id=" + id + "]";
	}
	
	
	
}
