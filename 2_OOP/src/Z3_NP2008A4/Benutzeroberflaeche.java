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

public class Benutzeroberflaeche extends JFrame implements ActionListener {
	boolean ready = false;

	// Deklaration fuer die Assoziation zur Steuerung
	SpielSteuerung dieSpielSteuerung;

	// Grafische Komponenten
	JPanel pContenPane;
	JPanel pSpielfeld;
	JPanel pButtons;
	JButton btNeustart;
	JLabel lbStatus;
	JLabel lbErgebnis;
	Feld[][] buttons;
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
		buttons = new Feld[6][6];

		pContenPane = new JPanel();
		pSpielfeld = new JPanel();
		pButtons = new JPanel();
		btNeustart = new JButton("Neustart");
		btNeustart.addActionListener(this);
		lbStatus = new JLabel();
		lbStatus.setFont(new Font("Verdana", Font.PLAIN, 20));
		lbErgebnis = new JLabel();

		pSpielfeld.setLayout(new GridLayout(6, 6));

		for (int y = 0; y < 6; y++) {

			for (int x = 0; x < 6; x++) {
				pSpielfeld.add(new MyButton(new Feld(x, y)));

			}
		}

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
		pContenPane.add(pSpielfeld);
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
	public void feldClick(int x, int y) {

		dieSpielSteuerung.bearbeiteFeldClick(x, y);

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
	 * Muss implementiert werden, wenn das Interface ActionListener eingebunden
	 * wird. Wenn eine Komponente einen ActionListener hat, wird durch ein
	 * Standardereignis ein ActionEventObjekt erzeugt. Dieses wird dann der
	 * Methode actionPerformed() ??bergeben.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btNeustart)) {
			neustartClick();
		} else {

			// Das erste Zeichen des ActionCommands enth??lt den Wert der
			// xPos im Array buttons[x][y]. Das dritte Zeichen enth??lt den
			// yPos Wert.
			int x = Integer.parseInt(e.getActionCommand().substring(0, 1));
			int y = Integer.parseInt(e.getActionCommand().substring(2, 3));

			feldClick(x, y);
		}
	}

	/**
	 * Wird ausgef??hrt wenn der Button Neustart gedr??ckt wurde.
	 */
	private void neustartClick() {
		System.out.println("Neustart Click");
		dieSpielSteuerung.neustartClick();
	}

	public void aktualisiereSpiefeld(int[][] spielfeld) {

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

	synchronized void waitFor() throws Exception {
		System.out.println(Thread.currentThread().getName()
				+ " is entering waitFor().");

		wait();

		System.out.println(Thread.currentThread().getName()
				+ " resuming execution.");
	}

	synchronized void start() {
		ready = true;
		notify();
	}

}
