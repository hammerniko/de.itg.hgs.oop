package Z5_HP2016A3_Ismail_Nikolai;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame {

	Steuerung dieSteuerung;

	private int h = 1080;
	private int w = 1920;
	private int width = 600;
	private int height = 350;
	private static final String TITEL = "Organisation Ballsportturnier in der Schule";
	private static final String EINST = "Einstellungen";
	private static final String HEADER = "Turnierplanung, Organisation, Auswertung";
	private static final String RESET = "Programm zuruecksetzen";
	private static final String CLOSE = "Programm beenden";

	Container cp = getContentPane();
	JLabel lbHeader;
	JLabel Leerzeichen;
	JLabel Leerzeichen1;
	JMenuBar mb;
	JMenu mEinstellungen;
	JMenuItem miResetProgress, miClose;
	JPanel pTabelle;
	JPanelEinstellungen card1;
	JPanelRegMannschaften card2;
	JPanelRegErgebnisse card3;
	JPanelRegTabelle card4;

	private JPanel einstellungCP = new JPanel();
	GridBagConstraints gbc = new GridBagConstraints();

	public GUI(Steuerung pSteuerung) {

		dieSteuerung = pSteuerung;

		setTitle(TITEL);
		setBounds(w / 2 - width / 2, h / 2 - height / 2, width, height);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		initC();
		addListeners();
		addC();

		setVisible(true);
	}

	private void addListeners() {

		miResetProgress.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clickInit();
			}
		});

		miClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clickBeenden();
			}
		});
	}

	private void addC() {

		sichtbarEinstellung();

		mEinstellungen.add(miResetProgress);
		mEinstellungen.add(miClose);
		mb.add(mEinstellungen);
		setJMenuBar(mb);

		gbc.gridx = 0;
		gbc.gridy = 0;
		einstellungCP.add(Leerzeichen1, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		einstellungCP.add(lbHeader, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		einstellungCP.add(Leerzeichen, gbc);

		cp.add(einstellungCP, BorderLayout.NORTH);
		cp.add(pTabelle, BorderLayout.CENTER);
		setContentPane(cp);
	}

	private void initC() {
		einstellungCP.setLayout(new GridBagLayout());
		cp = new JPanel(new BorderLayout());

		lbHeader = new JLabel(HEADER);
		Leerzeichen = new JLabel(
				"_________________________________________________________");
		Leerzeichen1 = new JLabel("      ");
		lbHeader.setFont(new Font("Arial", 0, 22));

		mb = new JMenuBar();
		mEinstellungen = new JMenu(EINST);

		miResetProgress = new JMenuItem(RESET);
		miClose = new JMenuItem(CLOSE);

		card1 = new JPanelEinstellungen(this);

		pTabelle = new JPanel(new CardLayout());
		pTabelle.add(card1, "Einstellungen");

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.insets = new Insets(5, 5, 5, 5);
	}

	public void clickInit() {
		dieSteuerung.resetProg();
	}

	public void clickSpeichernEinstellungen() {
		dieSteuerung.speichereEinstellungen();
	}

	public void clickSpeichernMannschaften() {
		dieSteuerung.speichereMannschaften();
	}

	public void clickZusammenfassenErgebnis() {
		dieSteuerung.zusammenfassenErgebnisse();
	}

	public void clickBestimmeRangfolge() {
		dieSteuerung.bestimmeRangfolge();
	}

	public void clickBeenden() {
		dispose();
	}

	public String gibNameMannschaft(int pZeile) {
		return (String) card2.model.getValueAt(pZeile, 1);
	}

	public void gibErgebnisPaarung(int pZeile) {

		int tore_M1 = Integer.parseInt((String) card3.model.getValueAt(pZeile, 4));
		int tore_M2 = Integer.parseInt((String) card3.model.getValueAt(pZeile, 6));
		dieSteuerung.diePaarung[pZeile].eintragenErgebnis(tore_M1, tore_M2);
	}

	public void anzeigenPaarung(int pZeile, String pM1, String pM2) {

		card3.model.setValueAt(pM1, pZeile, 1);
		card3.model.setValueAt(pM2, pZeile, 3);
	}

	public void anzeigenInTab(int pZeile, int pRang, String pMannschaft, int pSpiele, int pPunkte, int pTorePlus,
			int pToreMinus) {

		if (pRang == 0) {
			card4.model.setValueAt("", pZeile, 0);
		} else {
			card4.model.setValueAt(pRang, pZeile, 0);
		}

		card4.model.setValueAt(pMannschaft, pZeile, 1);
		card4.model.setValueAt(pSpiele, pZeile, 2);
		card4.model.setValueAt(pPunkte, pZeile, 3);
		card4.model.setValueAt(pTorePlus, pZeile, 4);
		card4.model.setValueAt(pToreMinus, pZeile, 5);
	}

	public void sichtbarEinstellung() {

		showCardlayout("Einstellungen");
	}

	private void showCardlayout(String string) {
		CardLayout cl = (CardLayout) (pTabelle.getLayout());
		cl.show(pTabelle, string);
	}

	public void sichtbarReg1_Mannschaften() {

		card2 = new JPanelRegMannschaften(this, dieSteuerung.getDieMannschaft());
		pTabelle.add(card2, "Mannschaften");

		showCardlayout("Mannschaften");
	}

	public void sichtbarReg2_Ergebnisse() {

		card3 = new JPanelRegErgebnisse(this, dieSteuerung.getDieMannschaft());
		pTabelle.add(card3, "Ergebnisse");

		showCardlayout("Ergebnisse");
	}

	public void sichtbarReg3_Tabelle() {
		card4 = new JPanelRegTabelle(this, dieSteuerung.getDieMannschaft());
		pTabelle.add(card4, "Tabelle");

		showCardlayout("Tabelle");
	}

	public int gibPunkteRegel() {
		return card1.gibPunkteRegel();
	}

	public int gibAnzahlMannschaften() {
		return card1.gibAnzahlMannschaften();
	}

	public void showInputError(String message) {
		JOptionPane.showMessageDialog(this, message, "Eingabefehler", JOptionPane.ERROR_MESSAGE);
	}

	public int gibAnzahlPaarungen() {
		return dieSteuerung.getAnzahlPaarungen();
	}

}
