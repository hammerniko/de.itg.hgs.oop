package Z8_HP2001_Minesweeper;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;

public class Spieloberflaeche extends JFrame {

	private JPanel panelSpielbrett;
	
	// Deklaration der Assoziation
	Spielsteuerung dieSteuerung;

	public Spieloberflaeche() {
		// Bidirektionale Assoziation zur Steuerung
		dieSteuerung = new Spielsteuerung(this);
		
		JPanel panelSpielbrett = new JPanel();
		getContentPane().add(panelSpielbrett, BorderLayout.CENTER);
		panelSpielbrett.setLayout(new GridLayout(SpielDaten.ANZAHL_FELDER, SpielDaten.ANZAHL_FELDER, 0, 0));
		
		JPanel panelButtons = new JPanel();
		getContentPane().add(panelButtons, BorderLayout.SOUTH);
		
		JButton btnNeuesSpiel = new JButton("Neues Spiel");
		panelButtons.add(btnNeuesSpiel);
		
		JButton btnNewButton = new JButton("Spiel beenden");
		panelButtons.add(btnNewButton);
		
	}

	public void zeigeMeldung(String meldung) {
		System.out.println(meldung);

	}

	public void mausClickAufFeldXY() {
		int x = 2;
		int y = 1;

		dieSteuerung.spieleZug(x, y);

	}

	public void neuesSpiel() {
		setAnzahlMinen();
		dieSteuerung.initialisiereSpiel();

	}

	private void setAnzahlMinen() {
		int anzalMinen = 5; // wird ueber neues Spiel eingestellt
		dieSteuerung.setDieAnzahlMinen(anzalMinen);
	}

	public void initialisiereSpielOberflaeche() {
		for (int y = 0; y < SpielDaten.ANZAHL_FELDER; y++) {
			for (int x = 0; x < SpielDaten.ANZAHL_FELDER; x++) {
				    
					panelSpielbrett.add(new MineButton(x, y));
			}
		}

	}

	public void zeigeSpielbrett() {
		for (int x = 0; x < SpielDaten.ANZAHL_FELDER; x++) {
			for (int y = 0; y < SpielDaten.ANZAHL_FELDER; y++) {
				System.out.println();
			}
		}
	}

}
