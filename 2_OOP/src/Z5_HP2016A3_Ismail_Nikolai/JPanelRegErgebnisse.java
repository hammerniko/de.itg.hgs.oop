package Z5_HP2016A3_Ismail_Nikolai;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

public class JPanelRegErgebnisse extends JPanelReg {

	GUI dieGUI;
	Mannschaft[] dieMannschaft;

	private int anzPaarungen;
	private Object[] columnName = { "Paarung", "Mannschaft 1", "-", "Mannschaft 2", "Tore M1", ":", "Tore M2" };
	private Object[] data = new Object[15];

	JTabbedPane tappedPane;
	JTable table;
	DefaultTableModel model;
	JPanel panelMannschaften, panelErgebnisse, panelTabelle, pButton;
	JLabel lbRegister;
	JButton btZusErg;
	JScrollPane pane;

	public JPanelRegErgebnisse(GUI parent, Mannschaft[] mannschaft) {

		dieGUI = parent;
		dieMannschaft = mannschaft;

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
		pButton = new JPanel(new FlowLayout());

		makeTable();
		addTabs();

		btZusErg = new JButton("Ergebnis Zusammenfassen");
		btZusErg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ergebnisseUebergeben();
				dieGUI.clickZusammenfassenErgebnis();
			}
		});
	}

	private void ergebnisseUebergeben() {

		for (int pZeile = 0; pZeile < anzPaarungen; pZeile++) {
			dieGUI.gibErgebnisPaarung(pZeile);
		}
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

		horizontalAlignment(2);
		horizontalAlignment(5);
		reSize(2);
		reSize(5);
	}

	private void reSize(int i) {
		table.getColumnModel().getColumn(i).setPreferredWidth(20);
	}

	private void horizontalAlignment(int i) {

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
	}

	@Override
	public void addTabs() {

		tappedPane.addTab("1. Mannschaften", panelMannschaften);
		tappedPane.addTab("2. Ergebnisse", panelErgebnisse);
		tappedPane.addTab("3. Tabelle", panelTabelle);
		tappedPane.setPreferredSize(new Dimension(150, 30));
		tappedPane.setEnabledAt(0, false);
		tappedPane.setEnabledAt(2, false);
		tappedPane.setSelectedIndex(1);
	}

	public void getData() {

		anzPaarungen = dieGUI.gibAnzahlPaarungen();

		for (int j = 0; j < anzPaarungen; j++) {

			data[0] = j;
			data[2] = "<->";
			data[4] = "0";// Tore M1
			data[5] = ":";
			data[6] = "0";// Tore M2

			model.addRow(data); // essential for adding sth. in Table
		}
	}

	@Override
	public void addC() {

		pButton.add(btZusErg);

		panelMannschaften.add(pane, BorderLayout.CENTER); // table ....
		panelMannschaften.add(pButton, BorderLayout.PAGE_END);

		this.add(lbRegister, BorderLayout.PAGE_START);
		this.add(tappedPane, BorderLayout.CENTER);
	}
}
