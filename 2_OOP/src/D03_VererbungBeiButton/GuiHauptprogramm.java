package D03_VererbungBeiButton;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Gui.. ist ein spezieller JFrame und zeigt einen
 * Button der Selbsterstellen Klasse MeinButton1
 * @author hr
 *
 */
public class GuiHauptprogramm extends JFrame {
    
	//Inhaltsfenster
    MeinPanel contentPane;
     
    //Konstruktor
    public GuiHauptprogramm(){
       
        contentPane = new MeinPanel();
        
        //Setzt das Inhaltsfenter der Gui
        setContentPane(contentPane);
        
        //Schliesst den Java Prozess, wenn die Schliessen-Schaltfläche geklickt wurde
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
