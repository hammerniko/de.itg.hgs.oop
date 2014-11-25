package Z2_NP2008A4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Benutzeroberflaeche extends JFrame implements ActionListener {

	// Deklaration fuer die Assoziation zur Steuerung
	SpielSteuerung dieSpielSteuerung;

	// Grafische Komponenten
	JPanel pContenPane;
	JPanel pSpielfeld;
	JPanel pButtons;
	JButton btNeustart;
	JLabel lbStatus;
	JButton[][] buttons;
	
	//Konstanten
	public static final int ANZAHL_FELDER = 6;
	public static final int SIZE_X=800;
	public static final int SIZE_Y=400;

	/**
	 * Konstruktor
	 */
	public Benutzeroberflaeche() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Fifteen");
		initKomponents();

	}

	
	/**
	 * Initialisiert die grafischen Komponenten und
	 * Container der Oberfläche
	 */
	private void initKomponents() {
		buttons = new JButton[6][6];

		pContenPane = new JPanel();
		pSpielfeld = new JPanel();
		pButtons = new JPanel();
		btNeustart = new JButton("Neustart");
		btNeustart.addActionListener(this);
		lbStatus = new JLabel("ready");
		lbStatus.setFont(new Font("Verdana", Font.PLAIN, 20));

		pSpielfeld.setLayout(new GridLayout(6, 6));

		for (int y = 0; y < buttons.length; y++) {
			for (int x = 0; x < buttons.length; x++) {
				buttons[x][y] = new JButton();
				
				//Fügt einen String zum Button hinzu, der mit getActioncommand wieder abgefragt werden kann
				//wenn auf den Button geklickt wurde
				buttons[x][y].setActionCommand(x + "," + y);
				
				//Gibt dem Button einen Standardlistener.
				//Der Übergabeparameter this gibt an, das die Methode actionperformed 
				//in dieser Klasse zu finden ist
				//Die Klasse muss dafür das Interface ActionListener implementieren
				//und die Methode actionperformed() überschreiben.
				//Wird der Button gedrückt, wird ein ActionEvent-Objekt erzeugt
				//und der Methode actionPerformed() übergeben.
				buttons[x][y].addActionListener(this);
				
				
				
				//Hinzufügen der Buttons zum Container
				pSpielfeld.add(buttons[x][y]);
				
			}
		}

		pButtons.setLayout(new FlowLayout(FlowLayout.LEFT));
		pButtons.add(btNeustart);
		pButtons.add(lbStatus);

		pContenPane.setLayout(new GridLayout(1, 2));
		pContenPane.add(pSpielfeld);
		pContenPane.add(pButtons);

		setContentPane(pContenPane);
		setSize(SIZE_X,SIZE_Y);
		
		//Allen Komponenten ausreichend Platz  geben
		//pack();
	}

	
	
	
	
	/**
	 * Wird aufgerufen wenn auf ein feld geklickt wurde.
	 * 
	 * @param x
	 * @param y
	 */
	public void feldClick(int x, int y) {
		System.out.println("feldClick("+x+","+y+")");
		//Botschaft an die Spielsteuerung
		dieSpielSteuerung.bearbeiteFeldClick(x, y);

	}

	
	
	
	
	/**
	 * zur Herstellung der bidirektionalen Assoziation.
	 * Wird von der Steuerung aus aufgerufen.
	 * Diese übergibt einen Zeiger von sich selbst an die Oberflaeche
	 * 
	 * @param spielSteuerung
	 */
	public void linkSteuerung(SpielSteuerung spielSteuerung) {
		dieSpielSteuerung = spielSteuerung;
	}
	

	
	
	
	/**
	 * Muss implementiert werden, wenn das Interface ActionListener eingebunden wird.
	 * Wenn eine Komponente einen ActionListener hat, wird durch ein Standardereignis
	 * ein ActionEventObjekt erzeugt. Dieses wird dann der Methode actionPerformed() 
	 * übergeben.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btNeustart)) {
			neustartClick();
		} else {

			//Das erste Zeichen des ActionCommands enthält den Wert der
			//xPos im Array buttons[x][y]. Das dritte Zeichen enthält den
			//yPos Wert.
			int x = Integer.parseInt(e.getActionCommand().substring(0, 1));
			int y = Integer.parseInt(e.getActionCommand().substring(2, 3));
			
			feldClick(x, y);
		}
	}

	
	
	
	/**
	 * Wird ausgeführt wenn der Button Neustart 
	 * gedrückt wurde.
	 */
	private void neustartClick() {
		// TODO Auto-generated method stub
		
	}

}
