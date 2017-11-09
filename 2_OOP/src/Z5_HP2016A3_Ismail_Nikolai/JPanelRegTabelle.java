package Z5_HP2016A3_Ismail_Nikolai;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class JPanelRegTabelle extends JPanelReg {

	GUI dieGUI;
	Mannschaft[] dieMannschaft;

	private int anzPaarungen;
	private Object[] columnName = { "Rang", "Mannschaft", "Spiele", "Punkte", "Tor+", "Tor-" };
	private Object[] data = new Object[6];

	JTabbedPane tappedPane;
	JTable table;
	DefaultTableModel model;
	JPanel panelMannschaften, panelErgebnisse, panelTabelle, pButtons;
	JLabel lbRegister;
	JButton btRangfolge, btReset;
	JScrollPane pane;

	public JPanelRegTabelle(GUI parent, Mannschaft[] mannschaft) {

		dieGUI = parent;
		dieMannschaft = mannschaft;

		anzPaarungen = dieGUI.gibAnzahlPaarungen();
		initC();
		getData();

		this.setLayout(new BorderLayout());

		addC();
	}

	@Override
	public void initC() {

		lbRegister = new JLabel("  Register von 1 bis 3 nacheinander bearbeiten");
		tappedPane = new JTabbedPane();
		model = new DefaultTableModel();
		panelMannschaften = new JPanel(new BorderLayout());
		pButtons = new JPanel(new FlowLayout());

		makeTable();
		addTabs();

		btRangfolge = new JButton("Rangfolge Bestimmen");
		btRangfolge.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dieGUI.clickBestimmeRangfolge();
			}
		});

		btReset = new JButton("Alles Zurücksetzen");
		btReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dieGUI.clickInit();
			}
		});
	}

	public void makeTable() {

		table = new JTable() {
			// make Read-Only fields
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 4 || column == 6 ? true : false;
			}
		};

		model.setColumnIdentifiers(columnName);
		table.setModel(model);
		pane = new JScrollPane(table);
		pane.setLayout(new ScrollPaneLayout());
	}

	@Override
	public void addTabs() {

		tappedPane.addTab("1. Mannschaften", panelMannschaften);
		tappedPane.addTab("2. Ergebnisse", panelErgebnisse);
		tappedPane.addTab("3. Tabelle", panelTabelle);
		tappedPane.setPreferredSize(new Dimension(150, 30));
		tappedPane.setEnabledAt(0, false);
		tappedPane.setEnabledAt(1, false);
		tappedPane.setSelectedIndex(2);
	}

	public void getData() {

		for (int j = 0; j < anzPaarungen; j++) {

			data[0] = "";
			data[1] = "";
			data[2] = "";
			data[3] = "";
			data[4] = "";// Tore M1
			data[5] = "";
			model.addRow(data); // essential for adding sth. in Table
		}
	}

	@Override
	public void addC() {

		pButtons.add(btRangfolge);
		pButtons.add(btReset);

		panelMannschaften.add(pane, BorderLayout.CENTER); // table ....
		panelMannschaften.add(pButtons, BorderLayout.PAGE_END);

		this.add(lbRegister, BorderLayout.PAGE_START);
		this.add(tappedPane, BorderLayout.CENTER);
	}
}
