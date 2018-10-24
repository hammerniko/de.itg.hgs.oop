package K1_OOP_Uebung_AssoziationUndVererbung;

public class Bauteil {
	
	private static int anzahlHinzugefuegterBauteile = 0;
	private int bauteilNr;
	private String bezeichnung;
	private Hersteller derHersteller;

	public int getBauteilNr() {
		return bauteilNr;
	}

	public void setBauteilNr(int bauteilNr) {
		this.bauteilNr = bauteilNr;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public Bauteil(Hersteller h, String bezeichnung) {
		super();
		
		anzahlHinzugefuegterBauteile++;
		this.bauteilNr = anzahlHinzugefuegterBauteile;
		this.bezeichnung = bezeichnung;
		derHersteller = h;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() +" BtNr:" + bauteilNr + "\t" + bezeichnung + " Hersteller=" + derHersteller
				+ "\n";
	}
	
	

}
