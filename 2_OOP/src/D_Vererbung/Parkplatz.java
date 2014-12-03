package D_Vererbung;

public class Parkplatz {

	private int id;
	private static int anzahlParkplätze=0;

	public Parkplatz(){
		anzahlParkplätze++;
		id=anzahlParkplätze;
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
