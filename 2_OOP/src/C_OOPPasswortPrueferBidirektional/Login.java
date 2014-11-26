package C_OOPPasswortPrueferBidirektional;

public class Login {
	Gui dieGui;
	

	public void linkGui(Gui gui) {
		dieGui = gui;
	}
	
	
	
	private boolean pruefeBenutzername(String name){
		boolean returnvalue=false;
		
		if(name.equals("Hammer")){
			returnvalue = true;
		}
		
		return returnvalue;
	}
	
	
	private boolean pruefePasswort(String pwd){
		boolean returnvalue=false;
		if(pwd.equals("123")){
			returnvalue = true;
		}
		
		return returnvalue;
	}
	
	
	
	public void pruefeLogin(String name, String pwd){
		
		if(pruefeBenutzername(name) && pruefePasswort(pwd)){
			dieGui.aktualisiereStatus(2);
		}
		else{
			dieGui.aktualisiereStatus(1);
		}
		
		
		
	}

}
