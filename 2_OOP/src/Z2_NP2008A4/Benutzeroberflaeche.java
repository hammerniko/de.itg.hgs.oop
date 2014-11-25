package Z2_NP2008A4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Benutzeroberflaeche extends JFrame implements ActionListener {

	// Deklaration für die Assoziation zur Steuerung
	SpielSteuerung dieSpielSteuerung;

	// Gui Komponenten
	JPanel pContenPane;
	JPanel pSpielfeld;
	JPanel pButtons;
	JButton btNeustart;
	JLabel lbStatus;
	JButton[][] buttons;

	public Benutzeroberflaeche() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Fünfzehn");

		initKomponents();

	}

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
				buttons[x][y].setActionCommand(x + "," + y);
				buttons[x][y].addActionListener(this);
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
		pack();
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
	 * zur Herstellung der bidirektionalen Assoziation
	 * 
	 * @param spielSteuerung
	 */
	public void linkSteuerung(SpielSteuerung spielSteuerung) {
		dieSpielSteuerung = spielSteuerung;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btNeustart)) {
			neustartClick();
		} else {

			int x = Integer.parseInt(e.getActionCommand().substring(0, 1));
			int y = Integer.parseInt(e.getActionCommand().substring(2, 3));
			System.out.println(x + "," + y);
			feldClick(x, y);
		}
	}

	private void neustartClick() {
		// TODO Auto-generated method stub
		
	}

}
