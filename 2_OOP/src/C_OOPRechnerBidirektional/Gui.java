package C_OOPRechnerBidirektional;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui extends JFrame {
	
	private static final String FORMATFEHLER = "Fehlermeldung";
	private static final String FEHLER = "Bitte nur Zahlen eingeben";

	//Assoziation vorbereiten
	Rechner derRechner;
	
	//Komponenten die in der Klasse be�tigt werden
	JButton btBerechnen;
	JButton btAbbrechen;
	JTextField tfZahlA;
	JTextField tfZahlB;
	JTextField tfErgebnis;
	JLabel lbStatus;
	
	public Gui(){
		
		//Assoziation herstellen und ein Objekt von sich selbst
		//an den Konstruktor der Klasse Rechner übergeben.
		//Dadurch kann eine bidirektionale Assoziation zwischen
		//beiden Klassen hergestellt werden.
		derRechner = new Rechner(this);
		
		init();
		
	}

	private void init() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Rechner");
		//Graue Flaeche/ Behaelter fuer Buttons, Textfelder ...
		JPanel contentPane = new JPanel();
		JPanel pEingabe = new JPanel();
		JPanel pButtons = new JPanel();
		
		pEingabe.setLayout(new GridLayout(3,2));
		this.setSize(600, 200);
		this.setContentPane(contentPane);
		
		//Komponenten fuer PanelEingabe erstellen
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
		
		//Komponenten einem Panel hinzuf�gen
		pEingabe.add(labelA);
		pEingabe.add(tfZahlA);
		pEingabe.add(labelB);
		pEingabe.add(tfZahlB);
		pEingabe.add(labelErgebnis);
		pEingabe.add(tfErgebnis);
		
		//Komponenten fuer Panel Buttons
		btBerechnen = new JButton("Berechnen");

		//Wenn der Button geklickt wird, soll die Methode
		//clickedBerechnen() aufgerufen werden.
		btBerechnen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clickedBerechnen();
			}
		});
		
		
		
		
		btAbbrechen = new JButton("Abbrechen");
		btAbbrechen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
	
		lbStatus = new JLabel();
		pButtons.add(lbStatus);
		pButtons.add(btAbbrechen);
		pButtons.add(btBerechnen);
		contentPane.add(pEingabe, BorderLayout.CENTER);
		contentPane.add(pButtons, BorderLayout.SOUTH);
		
	}

	
	private void clickedBerechnen() {
		
		//Daten holen 
		double a = leseZ1();
		double b = leseZ2();
		
		//Botschaft an derRechner. In der Gui wird nicht gerechnet, sondern nur
		//Benutzeraktionen ausgewertet. Der eigentliche Rechenvorgang findet in der
		//Klasse Rechner statt. -> Die Gui muss also eine Assoziation zum Rechnerobjekt 
		//derRechner haben.
		//Fuer das Ergebnis der Addition ist keine Bidirektionale-Assoziation notwendig,
		//da dieses nach Ablauf der Methode addiere zurückgegeben wird.
		double erg = derRechner.addiere(a, b);
		
		//Ergebnis anzeigen
		aktualisiereErgebnis(erg);
	}

	private double leseZ2() {
		double b=0;
		try {
			b = Double.parseDouble(tfZahlB.getText());
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, FEHLER, FORMATFEHLER, 0);
		}
		
		return b;
	}

	private double leseZ1() {
		double a=0;
		
			try {
				String strA = tfZahlA.getText();
				a = Double.parseDouble(tfZahlA.getText());
				
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, FEHLER, FORMATFEHLER, 0);
			}
		
			
			return a;
		
	}

	private void aktualisiereErgebnis(double erg) {
		tfErgebnis.setText(""+erg);
	}

	//Methode die von der Steuerung aus aufgerufen werden kann, damit die
	//Steuerung eine aktualisierte Meldung anzeigen kann
	public void aktualisiereStatus(String msg) {
		lbStatus.setText(msg);
	}

	
		


	

	
}
