package D03_VererbungBeiButton;

import javax.swing.JPanel;

public class MeinPanel extends JPanel {
	
	//Selbsterstellter Button
    MeinButton1 derButton;
    MeinButton1 derButton1;
    
    public MeinPanel() {
    	 derButton = new MeinButton1(); 
         derButton1 = new MeinButton1(); 
         
         add(derButton);
         add(derButton1);
    }

}
