package Z5_HP2016A3_Ismail_Nikolai;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class JPanelRegMannschaften extends JPanelReg {

	GUI dieGUI;
	Mannschaft[] dieMannschaft;

	private int anzMann;
	private Object[] columnName = { "Index", "Mannschaften" };
	private Object[] data = new Object[6];

	JTabbedPane tappedPane;
	JTable table;
	DefaultTableModel model;
	JPanel panelMannschaften, panelErgebnisse, panelTabelle, pButton;
	JLabel lbRegister;
	JButton btMannSpeichern;
	JScrollPane pane;

	public JPanelRegMannschaften(GUI parent, Mannschaft[] mannschaft) {

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

		btMannSpeichern = new JButton("Mannschaften Speichern");
		btMannSpeichern.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dieGUI.clickSpeichernMannschaften();
			}
		});
	}

	public void makeTable() {

		table = new JTable() {

			// make Read-Only fields
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 1 ? true : false;
			}

		};

		model.setColumnIdentifiers(columnName);
//		table.setBackground(Color.LIGHT_GRAY);
//		table.setForeground(Color.black);
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
		tappedPane.setEnabledAt(1, false);
		tappedPane.setEnabledAt(2, false);
	}

	public void getData() {

		anzMann = dieGUI.gibAnzahlMannschaften();

		for (int j = 0; j < anzMann; j++) {
			data[0] = j;
			data[1] = "Mannschaft" + (j);

			model.addRow(data); // essential for adding sth. in Table
		}
	}

	@Override
	public void addC() {

		pButton.add(btMannSpeichern);
		panelMannschaften.add(pane, BorderLayout.CENTER); // table ....
		panelMannschaften.add(pButton, BorderLayout.PAGE_END);

		this.add(lbRegister, BorderLayout.PAGE_START);
		this.add(tappedPane, BorderLayout.CENTER);
	}
}
