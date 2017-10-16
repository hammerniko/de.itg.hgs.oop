package C3_Beispiel_bidirektional;

public class Steuerung {
	//Assoziation
	private Gui dieGui;
	private Schueler s1;
	
	//Konstruktor
	public Steuerung() {
		dieGui = new Gui(this);
		
		s1 = new Schueler("Mueller", "Mike");
		
	}
	
	public void clickedOK() {
		
		String name = s1.getName();
		String vName = s1.getVorname();
		
		dieGui.zeigeSchueler(name+" "+vName);
		
		System.out.println("Schueler angezeigt");
		
		
	}
	

}
