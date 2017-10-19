package Z5_HP2016A3;

import java.awt.FlowLayout;
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
	
	private JScrollPane scrollPaneMannschaften;
	private JScrollPane scrollPaneErgebnisse;
	private JLabel lbReistertitel;
	private JTabbedPane tabbedPane;
	private JTable tableMannschaften;
	JTable tableErgebnisse;
	private JPanel pButton;
	private JButton btMannschaftenSpeichern;
	private JButton btErgebnisseZusammenfassen;
	private JButton btRangfolgeBestimmen;
	private JButton btAllesZuruecksetzen;
	private GUI dieGui;
	
	public JPanelMannschaften(GUI parent, Mannschaft dieMannschfaft[]) {
		dieGui = parent;
		
		this.setLayout(new GridLayout(3, 1));
		pButton = new JPanel();
		lbReistertitel = new JLabel("Register 1 bis 3 nacheinander bearbeiten");
		tabbedPane = new JTabbedPane();
		
		tableMannschaften = new JTable(new TableModelMannschaft(dieMannschfaft));
		
		//Ist notwendig, damit Überschriften der tabbedPane angezeigt werden können
		scrollPaneMannschaften = new JScrollPane(tableMannschaften);
		tableMannschaften.setFillsViewportHeight(true);
		
		
		
		tabbedPane.addTab("1.Mannschaften", scrollPaneMannschaften);
		tabbedPane.addTab("2.Ergebnisse", scrollPaneErgebnisse);
		tabbedPane.addTab("3.Tabelle", null);
		
		btErgebnisseZusammenfassen = new JButton("Ergebnisse zusammenfassen");
		btErgebnisseZusammenfassen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dieGui.clickZusammenfassenErgebnis();
				
			}
		});
		
		
		
		btAllesZuruecksetzen = new JButton("Alles zurücksetzen");
		btAllesZuruecksetzen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dieGui.clickInit();
				
			}
		});
		
		btRangfolgeBestimmen = new JButton("Rangfolge bestimmen");
		btRangfolgeBestimmen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dieGui.clickBestimmeRangfolge();
				
			}
		});
		
		
		
		btMannschaftenSpeichern = new JButton("Mannschaften speichern");
		btMannschaftenSpeichern.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dieGui.clickSpeichernManschaften();
				
			}
		});
		
		pButton.add(btMannschaftenSpeichern, new FlowLayout());
		this.add(lbReistertitel);
		this.add(tabbedPane);
		this.add(pButton);
		
		
	}
	
	 
	
	

}
