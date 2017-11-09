package Z5_HP2016A3_Ismail_Nikolai;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanelEinstellungen extends JPanel {

	GUI dieGUI;

	private int regel;
	private int anzMann;

	JPanel pEinstellungen, pAnzMann, pButton;
	JLabel lbEinst, lbSportart, lbAnzMann;
	JRadioButton rbFussball, rbHandball;
	JTextField tfMann;
	JButton btEinstSpeichern;
	ButtonGroup btGroup;

	GridBagConstraints gbc = new GridBagConstraints();

	private JPanel einstellungenCP = new JPanel();

	public JPanelEinstellungen(GUI parent) {

		dieGUI = parent;

		initC();
		this.setLayout(new BorderLayout());
		einstellungenCP.setLayout(new GridBagLayout());
		addC();
		addListeners();

	}

	private void addListeners() {

		btEinstSpeichern.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dieGUI.clickSpeichernEinstellungen();
			}
		});
	}

	private void addC() {
		gbc.gridx = 0;
		gbc.gridy = 0;
		einstellungenCP.add(lbEinst, gbc);

		// gbc.gridwidth = 7;
		gbc.gridx = 0;
		gbc.gridy = 1;
		einstellungenCP.add(lbSportart, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		einstellungenCP.add(rbFussball, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		einstellungenCP.add(rbHandball, gbc);

		btGroup.add(rbFussball);
		btGroup.add(rbHandball);

		rbFussball.setSelected(true);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		einstellungenCP.add(lbAnzMann, gbc);
		gbc.gridx = 2;
		gbc.gridy = 4;

		einstellungenCP.add(tfMann, gbc);

		pButton.add(btEinstSpeichern);
		this.add(einstellungenCP, BorderLayout.CENTER);
		this.add(pButton, BorderLayout.SOUTH);
	}

	private void initC() {

		pEinstellungen = new JPanel();
		pAnzMann = new JPanel(new FlowLayout());
		pButton = new JPanel(new FlowLayout());

		lbEinst = new JLabel("Einstellungen");
		lbSportart = new JLabel("Sportart w‰hlen");
		lbAnzMann = new JLabel("        Anz. Mannsch. (3..6): ");

		rbFussball = new JRadioButton("Fuﬂball (3-Punkte-Regel)");
		// rbFussball.setHorizontalAlignment(SwingConstants.CENTER);
		rbHandball = new JRadioButton("Handball (2-Punkte-Regel)");
		// rbHandball.setHorizontalAlignment(SwingConstants.CENTER);

		tfMann = new JTextField(2);
		tfMann.setText("3");

		btEinstSpeichern = new JButton("Einstellungen Speichern");

		btGroup = new ButtonGroup();

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);
	}

	public int gibPunkteRegel() {

		if (rbFussball.isSelected()) {
			regel = 3;
		} else {
			regel = 2;
		}

		return regel;
	}

	public int gibAnzahlMannschaften() {

		try {
			anzMann = Integer.parseInt(tfMann.getText());
		} catch (NumberFormatException e) {
			dieGUI.showInputError("Bitte nur Zahlen von 3 ... 6 eingeben");
		}

		return anzMann;
	}
}
