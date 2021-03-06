package Z3_NP2008A4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Benutzeroberflaeche extends JFrame {
	

	// Deklaration fuer die Assoziation zur Steuerung
	SpielSteuerung dieSpielSteuerung;

	// Grafische Komponenten
	JPanel pContenPane;
	GridButtonPanel pSpielfeld;
	JPanel pButtons;
	JButton btNeustart;
	JLabel lbStatus;
	JLabel lbErgebnis;
	//Feld[][] buttons;
	String[] text;

	// Konstanten
	public static final int ANZAHL_FELDER = 6;
	public static final int SIZE_X = 800;
	public static final int SIZE_Y = 400;

	/**
	 * Konstruktor
	 */
	public Benutzeroberflaeche() {
		setLookAndFeel();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Fifteen");

		initText();
		initKomponents();
		

	}

	private void initText() {
		text = new String[6];
		text[0] = "<html><body>Klicke zusammenh??ngende Felder an,<br>\n die in der Summe 15 ergeben</body></html>";
		text[1] = "Neue Gruppe!";
		text[2] = "Gruppe erweitert";
		text[3] = "15 sind voll";
		text[4] = "Welcher Gruppe soll das Feld zugeordnet werden? Klicke auf Gruppe!";
		text[5] = "bereits belegt";

	}

	/**
	 * Initialisiert die grafischen Komponenten und Container der Oberfl??che
	 */
	private void initKomponents() {
		

		pContenPane = new JPanel();
		pSpielfeld = new GridButtonPanel();
		pButtons = new JPanel();
		btNeustart = new JButton("Neustart");
		btNeustart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				neustartClick();
			}
		});
		
		lbStatus = new JLabel();
		lbStatus.setFont(new Font("Verdana", Font.PLAIN, 20));
		lbErgebnis = new JLabel();

		

		
		pButtons.setLayout(new BoxLayout(pButtons, BoxLayout.Y_AXIS));

		btNeustart.setAlignmentX(CENTER_ALIGNMENT);
		lbStatus.setAlignmentX(CENTER_ALIGNMENT);
		lbErgebnis.setAlignmentX(CENTER_ALIGNMENT);

		pButtons.add(Box.createRigidArea(new Dimension(0, 20)));
		pButtons.add(btNeustart);
		pButtons.add(Box.createRigidArea(new Dimension(0, 20)));
		pButtons.add(lbStatus);
		pButtons.add(Box.createRigidArea(new Dimension(0, 20)));
		pButtons.add(lbErgebnis);
		pButtons.add(Box.createRigidArea(new Dimension(0, 20)));

		pContenPane.setLayout(new GridLayout(1, 2));
		pContenPane.add(pSpielfeld.createGridPanel());
		pContenPane.add(pButtons);

		setContentPane(pContenPane);
		setSize(SIZE_X, SIZE_Y);
		setResizable(false);
		
	}

	
	/**
	 * Wird aufgerufen wenn auf ein feld geklickt wurde.
	 * 
	 * @param x
	 * @param y
	 */
	public void feldClick(Feld feld) {

		dieSpielSteuerung.bearbeiteFeldClick(feld);

	}

	/**
	 * zur Herstellung der bidirektionalen Assoziation. Wird von der Steuerung
	 * aus aufgerufen. Diese ??bergibt einen Zeiger von sich selbst an die
	 * Oberflaeche
	 * 
	 * @param spielSteuerung
	 */
	public void linkSteuerung(SpielSteuerung spielSteuerung) {
		dieSpielSteuerung = spielSteuerung;
	}

	

	/**
	 * Wird ausgefuehrt wenn der Button Neustart gedr??ckt wurde.
	 */
	private void neustartClick() {
		dieSpielSteuerung.neustartClick();
	}

	public void aktualisiereSpiefeld(Feld[] spielfeld) {
		pSpielfeld.setButtonData(spielfeld);
		
		
	}
	
	public void aktualisiereFeld(Feld feld){
		MyButton bt = pSpielfeld.getGridButton(feld.getPosX(), feld.getPosY());
		bt.setFeld(feld);
		bt.setBackground(feld.getFarbe());
		System.out.println("Feld gesetzt "+feld);
	}

	public void ausgebenText(int textNr, double spielstand) {
		lbStatus.setText(text[textNr]);
		lbErgebnis.setText("Spielstand:\t" + spielstand);
	}

	/**
	 * F??r Buttons mit Hintergrundfarbe auf dem Mac
	 */
	private void setLookAndFeel() {

		try {
			UIManager.setLookAndFeel(UIManager
					.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
