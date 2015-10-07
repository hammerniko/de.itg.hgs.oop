package Proj1_DateiOeffnenUndSpeichern;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Gui extends JFrame implements Dateiverwaltung {
	
	//Assoziation
	Steuerung dieSteuerung;
	
	//Grafische Komponenten
	JPanel contentPane;
	JMenuBar menuBar;
	JMenu menuDatei;
	JMenuItem menuItemOeffnen;
	JMenuItem menuItemSpeichern;
	JMenuItem menuItemSpeichernAls;
	JTextField tfAnzeige;
	
	
	
	//Konstruktor
	public Gui(){
		dieSteuerung = new Steuerung(this);
		initMenu();
		initGui();
		
	}
	

	private void initMenu() {
		menuBar = new JMenuBar();
		menuDatei = new JMenu("Datei");
		menuBar.add(menuDatei);
		
		menuItemOeffnen = new JMenuItem("Öffnen");
		menuItemOeffnen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				openFile();
			}
		});
		menuDatei.add(menuItemOeffnen);
		
		menuItemSpeichern = new JMenuItem("Speichern");
		menuItemSpeichern.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveFile();
				
			}
		});
		
		
		menuDatei.add(menuItemSpeichern);
		
		menuItemSpeichernAls = new JMenuItem("Speichern als");
		menuDatei.add(menuItemSpeichernAls);
		
		setJMenuBar(menuBar);
	}


	private void initGui() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(400, 400);
		
		//Hauptpanel
		contentPane = new JPanel();
		
		
		tfAnzeige = new JTextField(30);
		contentPane.add(tfAnzeige);
		
		
		
		
		setContentPane(contentPane);
		
	}


	@Override
	public File openFile() {
		System.out.println("Datei öffnen ausgewählt");
		dieSteuerung.dateiOeffnen();
		return null;
	}

	@Override
	public void saveFile() {
		System.out.println("Datei speichern angeklickt");
		dieSteuerung.dateiSpeichern();
		
	}

	@Override
	public void saveAsFile(File file, String path) {
		// TODO Auto-generated method stub
		
	}
	
	

}
