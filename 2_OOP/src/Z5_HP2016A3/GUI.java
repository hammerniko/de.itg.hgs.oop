package Z5_HP2016A3;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javafx.scene.text.Font;

public class GUI extends JFrame {
	
	//Konstanten
	public static final float SCHRIFTGROESSE_TITEL = 18;
	

	boolean debug;
	
	// Attribut für Assoziation zur Steuerung
	Steuerung dieSteuerung;
	
	//Objekte für die Gui
	JPanel contentPane;
	JPanel pTitel;
	JLabel lbTitel;
	JPanel pAnzeige;
	JPanelEinstellungen card1;
	JPanelMannschaften card2;
	JPanel card3;
	JPanel card4;
	
	JMenu mEinstellungen;
	JMenuBar menuBar;
	JMenuItem miEinstellungen;

	// Konstruktor
	public GUI(Steuerung pSteuerung) {
		debug = true;
		initComponents();
		addComponents();
		setVisible(true);
		setSize(600, 350);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		dieSteuerung = pSteuerung;
		
		
	}

	private void addComponents() {
		sichtbarEinstellungen();
		pTitel.add(lbTitel);
		contentPane.add(pTitel, BorderLayout.NORTH);
		contentPane.add(pAnzeige, BorderLayout.CENTER);
		
		menuBar.add(mEinstellungen);
		setJMenuBar(menuBar);
		
	}

	private void initComponents() {
		setTitle("Organisation Ballsportturnier in der Schule");
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		pTitel = new JPanel();
		
		lbTitel = new JLabel("Turnierplanung, Organisation, Auswertung");
		lbTitel.setFont (lbTitel.getFont ().deriveFont (SCHRIFTGROESSE_TITEL));
		
		
		
		card1 = new JPanelEinstellungen(this);
		card2 = new JPanelMannschaften(this);
		
		
		pAnzeige = new JPanel(new CardLayout());
		pAnzeige.add(card1,"Einstellungen");
		pAnzeige.add(card2,"Mannschaften");
				
		
		
		
		menuBar = new JMenuBar();
		mEinstellungen = new JMenu("Einstellungen");
		
		
		this.setContentPane(contentPane);
		
	}

	public void clickInit() {
		//aus Sequenzdiagramm 1 oben Seite 2
		dieSteuerung.resetProg();
	
	}

	public void clickSpeichernEinstellungen() {
		//aus Sequenzdiagramm 2 oben Seite 2
		System.out.println("Speichern Einstellungen geclickt");
		
		dieSteuerung.speichereEinstellungen();
		
		
		

	}

	public void clickSpeichernManschaften() {
		dieSteuerung.speichereMannschaften();
	}

	public void clickErmittelnPaarungen() {
		
	}

	public void clickZusammenfassenErgebnis() {
		sichtbarReg3_Tabelle();
	}

	public void clickBestimmeRangfolge() {
		dieSteuerung.bestimmeRangfolge();
	}

	public void clickBeenden() {

	}

	public String gibNameMannschaft(int pZeile) {
		// ermittle Name der Mannschaft

		return "Mannschaftsname...";
	}

	public int gibErgebnisPaarung(int pZeile, int Mannschaft) {
		// ermittle Ergebnis
		return 0;
	}

	public void anzeigenPaarung(int pZeile, String pM1, String pM2) {

	}

	public void anzeigenInTab(int pZeile, int pRang, String pMannschaft, int pSpiele, int pPunkte, int pTorePlus,
			int pToreMinus) {

	}

	public void sichtbarEinstellungen() {
		  CardLayout cl = (CardLayout)(pAnzeige.getLayout());
          cl.show(pAnzeige,"Einstellungen" );
		
	}

	public void sichtbarReg1_Mannschaften() {
		CardLayout cl = (CardLayout)(pAnzeige.getLayout());
        cl.show(pAnzeige,"Mannschaften" );
		
	}

	public void sichtbarReg2_Ergebnisse() {
		
	}

	public void sichtbarReg3_Tabelle() {
		
	}

	public int gibPunkteRegel() {
		
		// Regel ermitteln und zurückgeben 
		//Typcast ist notwendig, da das Anzeigepanel als
		//normales JPanel deklariert wurde
		int regel =   card1.getRegel();

		trace("Regel = "+regel);
		
		return regel;
	}

	public int gibAnzahlMannschaften() {
		//anzahl Mannschaften ermitteln
		//und zurückgeben
		int anzahlMannschaften = card1.getAnzahlMannschaften();
		
		trace("Anzahl Mannschaften = "+anzahlMannschaften);
		return anzahlMannschaften;
	}

	public void eintragenReg1_Index(int anzahlMannschaften) {
		// TODO Auto-generated method stub
		
	}

	
	public void trace(String meldung) {
		if(debug) {
			System.out.println(meldung);
		}
	}
	
	public void showInputError(String message) {
		JOptionPane.showMessageDialog(this,
			    message,
			    "Eingabefehler",
			    JOptionPane.ERROR_MESSAGE);
	}
	

}
