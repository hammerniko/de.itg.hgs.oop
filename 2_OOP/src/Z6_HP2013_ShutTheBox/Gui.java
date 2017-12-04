package Z6_HP2013_ShutTheBox;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui extends JFrame {
	
	JPanel jpSpieler1;
	JPanel jpSpieler2;
	JPanel jpWuerfel;
	JPanel jPButtons;
	JPanel jPKlappen;
	JPanel contenPane;
	JLabel lbName1;
	JLabel lbName2;
	JLabel lbPunkte1;
	JLabel lbPunkte2;
	JTextField tfName1;
	JTextField tfName2;
	JTextField tfPunkte1;
	JTextField tfPunkte2;
	JButton btWuerfeln;
	JButton btSpielerWechsel;
	JButton bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9;
	
	
	public static final String TITEL = "Shut the Box";
	private static final String WUERFELN = "würfeln";
	private static final String SPIELER_WECHSELN = "Spielerwechsel";
	
	public Gui(String pName1, String pName2) {
		setTitle(TITEL);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		jpSpieler1 = new JPanel();
		jpSpieler2 = new JPanel();
		jpWuerfel  = new JPanel();
		jPButtons = new JPanel();
		jPKlappen = new JPanel();
		contenPane = new JPanel();
		lbName1 = new JLabel("Name1:");
		lbName2 = new JLabel("Name2:");
		lbPunkte1 = new JLabel("Punkte1:");
		lbPunkte2 = new JLabel("Punkte2:");
		tfName1 = new JTextField(10);
		tfName2 = new JTextField(10);
		tfPunkte1= new JTextField(4);
		tfPunkte2= new JTextField(4);
		btWuerfeln = new JButton(WUERFELN);
		btSpielerWechsel= new JButton(SPIELER_WECHSELN);
		JButton bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9;
		
		
	}
	
	public void zeigePunkte(int pIdxSpieler, int pMinusPunkte) {
		
	}
	
	public void oeffneAlleKlappen() {
		
	}
	
	public void schliesseKlappe(int pWert) {
		
	}
	
	public void aktiviereWuerfelTaste() {
		
	}
	
	public void aktiviereWechselTaste() {
		
	}

	public void klickWechsleSpieler() {
		
	}
	
	public void klickWuerfeln() {
		
	}
}
