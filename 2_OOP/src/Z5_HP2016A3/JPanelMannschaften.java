package Z5_HP2016A3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class JPanelMannschaften extends JPanel {
	
	JScrollPane scrollPane;
	JLabel lbReistertitel;
	JTabbedPane tabbedPane;
	JTable tableMannschaften;
	JButton btMannschaftenSpeichern;
	GUI dieGui;
	
	public JPanelMannschaften(GUI parent) {
		dieGui = parent;
		
		this.setLayout(new GridLayout(3, 1));
		
		lbReistertitel = new JLabel("Register 1 bis 3 nacheinander bearbeiten");
		
		
		tabbedPane = new JTabbedPane();
		
				
		tableMannschaften = new JTable(new TableModelMannschaft());
		scrollPane = new JScrollPane(tableMannschaften);
		
		tabbedPane.addTab("1.Mannschaften", scrollPane);
		tabbedPane.addTab("2.Ergebnisse", null);
		tabbedPane.addTab("3.Tabelle", null);
		
		
		
		btMannschaftenSpeichern = new JButton("Mannschaften speichern");
		btMannschaftenSpeichern.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dieGui.clickSpeichernManschaften();
				
			}
		});
		
		this.add(lbReistertitel);
		this.add(tabbedPane);
		this.add(btMannschaftenSpeichern);
	}
	
	

}
