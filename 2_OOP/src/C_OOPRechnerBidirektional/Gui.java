package C_OOPRechnerBidirektional;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Gui extends JFrame {
	
	//Assoziation 
	Rechner derRechner;
	
	//Komponenten die in der Klasse beötigt werden
	JButton btBerechnen;
	JTextField tfZahlA;
	JTextField tfZahlB;
	JTextField tfErgebnis;
	JLabel lbStatus;
	
	
	public Gui(Rechner r){
		derRechner = r;
		
		derRechner.linkGui(this);
		
		
		System.out.println("Mein neuer Konstruktor");
		init();
		
	}

	private void init() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Rechner");
		//Graue Fläche/ Behälter für Buttons, Textfelder ...
		JPanel contenPane = new JPanel();
		JPanel pEingabe = new JPanel();
		JPanel pButtons = new JPanel();
		
		pEingabe.setLayout(new GridLayout(3,2));
		this.setSize(400, 100);
		this.setContentPane(contenPane);
		
		//Komponenten für PanelEingabe erstellen
		tfZahlA = new JTextField();
		tfZahlA.setColumns(20);
		tfZahlB = new JTextField();
		tfZahlB.setColumns(20);
		JLabel labelA = new JLabel("Zahl A:");
		JLabel labelB = new JLabel("Zahl B:");
		JLabel labelErgebnis = new JLabel("Ergebnis");
		tfErgebnis = new JTextField();
		tfErgebnis.setColumns(20);
		tfErgebnis.setEnabled(false);
		
		//Komponenten einem Panel hinzufügen
		pEingabe.add(labelA);
		pEingabe.add(tfZahlA);
		pEingabe.add(labelB);
		pEingabe.add(tfZahlB);
		pEingabe.add(labelErgebnis);
		pEingabe.add(tfErgebnis);
		
		//Komponenten für Panel Buttons
		btBerechnen = new JButton("Berechnen");
		btBerechnen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clickedBerechnen();
			}

			
		});
		
		JButton btAbbrechen = new JButton("Abbrechen");
		btAbbrechen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Abbrechen geklickt");
				
			}
		});
		
		
		lbStatus = new JLabel();
		pButtons.add(lbStatus);
		pButtons.add(btAbbrechen);
		pButtons.add(btBerechnen);
		
		
		contenPane.add(pEingabe, BorderLayout.CENTER);
		contenPane.add(pButtons, BorderLayout.SOUTH);
		
		
	}

	private void clickedBerechnen() {
		System.out.println("Berechnen geklickt");
		//Daten holen
		double a = Double.parseDouble(tfZahlA.getText());
		double b = Double.parseDouble(tfZahlB.getText());
		
		
	
		
		 
		double erg = derRechner.addiere(a, b);
		
		//Ergebnis anzeigen
		tfErgebnis.setText(""+erg);
		
	}

	public void aktualisiereStatus(String msg) {
		
		lbStatus.setText(msg);
	}

	
}
