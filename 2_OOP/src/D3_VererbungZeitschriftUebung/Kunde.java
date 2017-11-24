package D3_VererbungZeitschriftUebung;

public class Kunde {
	
	private int KdNr;
	private String name;
	private String vorname;
	
	
	private static int anzahlKunden = 0;
	
	
	public Kunde(String name, String vorname) {
		super();
		
		anzahlKunden++;
		
		KdNr = anzahlKunden;
		this.name = name;
		this.vorname = vorname;
	}
	
	public int getKdNr() {
		return KdNr;
	}
	public void setKdNr(int kdNr) {
		KdNr = kdNr;
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
		return "\nKunde [KdNr=" + KdNr + ", name=" + name + ", vorname=" + vorname + "]";
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		
		System.out.println("Kunde gelöscht");
		
	} 
	
	
	
	
	
	

}
