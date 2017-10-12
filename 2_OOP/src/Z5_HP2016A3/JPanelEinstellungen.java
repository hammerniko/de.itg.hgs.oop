package Z5_HP2016A3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class JPanelEinstellungen extends JPanel {
	
	JLabel lbTitel;
	JLabel lbAuswahl;
	JLabel lbAnzahlManschaften;
	JRadioButton rbFussball;
	JRadioButton rbHandball;
	ButtonGroup gruppe = new ButtonGroup();
	JButton btEinstellungenSpeichern;
	JTextField tfAnzahlMannschaften;
	GUI dieGui;
	private int regel;
	
	
	public JPanelEinstellungen(GUI parent) {
		dieGui = parent;
		initComponents();
		addComponents();
		addListeners();
		
		this.setLayout(new GridLayout(7, 1));
	}




	private void addComponents() {
		this.add(lbTitel);
		this.add(lbAuswahl);
		this.add(rbFussball);
		this.add(rbHandball);
		gruppe.add(rbFussball);
		gruppe.add(rbHandball);
		rbFussball.setSelected(true);
		
		this.add(lbAnzahlManschaften);
		this.add(tfAnzahlMannschaften);
		this.add(btEinstellungenSpeichern);
		
	}




	private void initComponents() {
		lbTitel = new JLabel("Einstellungen");
		lbAuswahl = new JLabel("Sportart w‰hlen");
		lbAnzahlManschaften = new JLabel("Anz. Mannschaft,(3..6):");
		rbFussball = new JRadioButton("Fuﬂball (3-Pkt-Regel");
		rbHandball = new JRadioButton("Handball (2-Pkt-Regel");
		btEinstellungenSpeichern = new JButton("Einstellungen speichern");
		tfAnzahlMannschaften = new JTextField("3");
	}
	
	private void addListeners() {
		btEinstellungenSpeichern.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dieGui.clickSpeichernEinstellungen();
				
			}
		});
	}

	public int getRegel() {
		if(rbFussball.isSelected()) {
			regel=3;
		}
		else {
			regel=2;
		}
		return regel;
	}
	
	public int getAnzahlMannschaften() {
		int anz=0;
		try {
			anz = Integer.parseInt(tfAnzahlMannschaften.getText());
			
			
		} catch (NumberFormatException e) {
			dieGui.showInputError( "Bitte nur Zahlen von 3 ... 6 eingeben");
		}
		
		return anz;
	}




	
}
