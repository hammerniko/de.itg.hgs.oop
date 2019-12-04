package M1_SD_Addierer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui extends JFrame {
	
	private static final String ANZAHL_BERECHNUNGEN = "AnzahlBerechnungen:";


	//Assoziation
	Rechner derRechner;
	

	private JPanel contentPane;
	private JTextField textFieldZahlA;
	private JTextField textFieldZahlB;
	private JTextField textFieldsumme;
	private JLabel lblAnzahlberechnungen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gui() {
		
		//Bidirektionale Assoziatione erstellen
		derRechner = new Rechner(this);
		
		
		setTitle("Einfacher Addierer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblZahlA = new JLabel("Zahl A:");
		lblZahlA.setBounds(37, 37, 61, 16);
		contentPane.add(lblZahlA);
		
		JLabel lblZahlB = new JLabel("Zahl B:");
		lblZahlB.setBounds(37, 80, 61, 16);
		contentPane.add(lblZahlB);
		
		textFieldZahlA = new JTextField();
		textFieldZahlA.setBounds(110, 31, 134, 28);
		contentPane.add(textFieldZahlA);
		textFieldZahlA.setColumns(10);
		
		textFieldZahlB = new JTextField();
		textFieldZahlB.setBounds(110, 74, 134, 28);
		contentPane.add(textFieldZahlB);
		textFieldZahlB.setColumns(10);
		
		JButton btnAddiere = new JButton("Addiere");
		btnAddiere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickedAddiere();
			}
		});
		btnAddiere.setBounds(300, 243, 117, 29);
		contentPane.add(btnAddiere);
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickedAbbrechen();
			}
		});
		btnAbbrechen.setBounds(414, 243, 117, 29);
		contentPane.add(btnAbbrechen);
		
		lblAnzahlberechnungen = new JLabel(ANZAHL_BERECHNUNGEN+ 0);
		lblAnzahlberechnungen.setBounds(37, 248, 177, 16);
		contentPane.add(lblAnzahlberechnungen);
		
		JLabel lblSumme = new JLabel("Summe:");
		lblSumme.setBounds(37, 125, 61, 16);
		contentPane.add(lblSumme);
		
		textFieldsumme = new JTextField();
		textFieldsumme.setEditable(false);
		textFieldsumme.setBounds(110, 119, 134, 28);
		contentPane.add(textFieldsumme);
		textFieldsumme.setColumns(10);
	}

	protected void clickedAbbrechen() {
		textFieldsumme.setText("");
		textFieldZahlA.setText("");
		textFieldZahlB.setText("");
		
		
	}

	protected void clickedAddiere() {
		//Eingabe
		String strZahlA = textFieldZahlA.getText();
		String strZahlB = textFieldZahlB.getText();
		
		//Verarbeitung
		double za = Double.parseDouble(strZahlA);
		double zb = Double.parseDouble(strZahlB);
		double summe = derRechner.berechneSumme(za, zb);
		
		//Ausgabe
		textFieldsumme.setText(""+summe);
		
		
	}

	public void zeigeAnzahlRechnungen(int anzahlRechnungen) {
		lblAnzahlberechnungen.setText(ANZAHL_BERECHNUNGEN+anzahlRechnungen);
		
	}
}
