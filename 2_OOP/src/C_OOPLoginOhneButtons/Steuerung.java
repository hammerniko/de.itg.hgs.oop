package C_OOPLoginOhneButtons;

public class Steuerung {

	private final String benutzername="Niko";
	private final String kennwort="12345";
	
	
	//Assoziation
	private Gui dieGui;
	
	
	public Steuerung() {
		dieGui = new Gui(this);
		
		
	}
	
	public void pruefeBenutzername(String pName) {
		String meldung;
		if(pName.equals(benutzername)) {
			meldung = "Benutzername ok";
			dieGui.setzeFocusAufKW();
		}
		else {
			meldung = "Benutzername falsch!";
			dieGui.setzeFocusAufBN();
		}
		
		dieGui.zeigeStatus(meldung);
	}
	
	public void pruefeKennwort(String pKennwort) {
		String meldung;
		if(pKennwort.equals(kennwort)) {
			meldung = "Anmeldung ok";
		}
		else {
			meldung = "Kennwort falsch!";
			dieGui.setzeFocusAufKW();
		}
		
		dieGui.zeigeStatus(meldung);
	}
	
	
	
}
