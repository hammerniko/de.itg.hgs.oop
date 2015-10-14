package Proj1_DateiOeffnenUndSpeichern;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.Document;
import javax.swing.undo.UndoManager;
import javax.xml.parsers.DocumentBuilder;

 

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
	JScrollPane scrollpane;

	JTextArea taAnzeige;
	

	JTextArea ta;
	
	//Konstruktor
	public Gui(){
		dieSteuerung = new Steuerung(this);
	
		initMenu();
		initGui();
	}
	

	private void initMenu() {
		menuBar = new JMenuBar();
		menuDatei = new JMenu("File");
		menuBar.add(menuDatei);
		
		menuItemOeffnen = new JMenuItem("Open");
		menuItemOeffnen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				openFile();
			}
		});
		
		menuDatei.add(menuItemOeffnen);
		
		menuItemSpeichern = new JMenuItem("Save");
		erstelleMenuItemOeffnen();
		erstelleMenuItemSpeichern();
		erstelleMenuItemSpeichernAls();
		setJMenuBar(menuBar);
	}


	private void erstelleMenuItemSpeichernAls() {
		menuItemSpeichernAls = new JMenuItem("Speichern als");
		menuDatei.add(menuItemSpeichernAls);
	}


	private void erstelleMenuItemSpeichern() {
		menuItemSpeichern = new JMenuItem("Speichern");
		menuItemSpeichern.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveFile();
				
			}
		});
		
		
		menuDatei.add(menuItemSpeichern);
		
		menuItemSpeichernAls = new JMenuItem("Save As");
		menuDatei.add(menuItemSpeichernAls);
		
		setJMenuBar(menuBar);
	}


	private void erstelleMenuItemOeffnen() {
		menuItemOeffnen = new JMenuItem("�ffnen");
		menuItemOeffnen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openFile();
			}
		});
		menuDatei.add(menuItemOeffnen);
	}


	private void initGui() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(400, 400);
		
		//Hauptpanel
		contentPane = new JPanel();
		taAnzeige = new JTextArea("",20,30);
		scrollpane = new JScrollPane();
		scrollpane.setViewportView(taAnzeige);
		contentPane.add(scrollpane);
		
		
		
		
		contentPane.setLayout(new BorderLayout());
		erstelleScrollpane();
	
		contentPane.add(scrollpane,BorderLayout.CENTER);
		setContentPane(contentPane);
		
	}


	private void erstelleScrollpane() {
		int v = JScrollPane.VERTICAL_SCROLLBAR_ALWAYS;
		int h = JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS;
		ta= new JTextArea();
		scrollpane = new JScrollPane(ta);
		scrollpane.setVerticalScrollBarPolicy(v);
		scrollpane.setHorizontalScrollBarPolicy(h);
	}


	@Override
	public File openFile() {
		System.out.println("Datei �ffnen ausgew�hlt");
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
	
	
	public void setText(String text){
		ta.setText(text);
	}
	

}
