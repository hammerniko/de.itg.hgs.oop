package D_Vererbung;

public class Parkplatz {

	private int id;
	private static int anzahlParkpl�tze=0;

	public Parkplatz(){
		anzahlParkpl�tze++;
		id=anzahlParkpl�tze;
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
