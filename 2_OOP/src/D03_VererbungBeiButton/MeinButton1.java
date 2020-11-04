package D03_VererbungBeiButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * MeinButton1 ist ein speieller JButton und erbt deshalb von der Klasse
 * JButton. Das Interface ActionListener zwingt dazu die Methode
 * actionPerormed() zu implementieren. Im Konstruktor wird dem Button Objelt ein
 * ActionListener hinzugefügt, der die zugehörige Methode actionPerformed()
 * innerhalb der klasse sucht und findet.
 * 
 * @author hr
 *
 */
public class MeinButton1 extends JButton implements ActionListener {

	public static final int SPIELER_1 = -1; // XX
	public static final int SPIELER_2 = 1; // O
	private int aktuellerSpieler;

	// Konstruktor
	public MeinButton1() {

		// Anfangszustand
		aktuellerSpieler = SPIELER_1;
		setText("X");

		// Der Button soll auf Klicks reagieren
		// und die Methode actionPerformed innerhalb der Klasse
		// aufrufen wenn er geklickt wurde
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("geklickt");

		// Wechseln zwische X und O
		wechseleZustand();

	}

	private void wechseleZustand() {
		aktuellerSpieler = aktuellerSpieler * -1;

		switch (aktuellerSpieler) {
		case SPIELER_1:setText("X");break;
		case SPIELER_2:setText("O");break;
		}
	}
}
