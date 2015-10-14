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
<<<<<<< HEAD
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
=======
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
>>>>>>> branch 'master' of https://github.com/hammerniko/de.itg.hgs.oop.git


 

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
<<<<<<< HEAD
	JTextArea taAnzeige;
	
	
=======
	JTextArea ta;
>>>>>>> branch 'master' of https://github.com/hammerniko/de.itg.hgs.oop.git
	
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
<<<<<<< HEAD
		
		menuItemOeffnen = new JMenuItem("Open");
		menuItemOeffnen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				openFile();
			}
		});
		
		menuDatei.add(menuItemOeffnen);
		
		menuItemSpeichern = new JMenuItem("Save");
=======
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
>>>>>>> branch 'master' of https://github.com/hammerniko/de.itg.hgs.oop.git
		menuItemSpeichern.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveFile();
				
			}
		});
		
		
		menuDatei.add(menuItemSpeichern);
<<<<<<< HEAD
		
		menuItemSpeichernAls = new JMenuItem("Save As");
		menuDatei.add(menuItemSpeichernAls);
		
		setJMenuBar(menuBar);
=======
	}


	private void erstelleMenuItemOeffnen() {
		menuItemOeffnen = new JMenuItem("Öffnen");
		menuItemOeffnen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openFile();
			}
		});
		menuDatei.add(menuItemOeffnen);
>>>>>>> branch 'master' of https://github.com/hammerniko/de.itg.hgs.oop.git
	}


	private void initGui() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(400, 400);
		
		//Hauptpanel
		contentPane = new JPanel();
<<<<<<< HEAD
		taAnzeige = new JTextArea("",20,30);
		scrollpane = new JScrollPane();
		scrollpane.setViewportView(taAnzeige);
		contentPane.add(scrollpane);
		
		
		
		
=======
		contentPane.setLayout(new BorderLayout());
		erstelleScrollpane();
	
		contentPane.add(scrollpane,BorderLayout.CENTER);
>>>>>>> branch 'master' of https://github.com/hammerniko/de.itg.hgs.oop.git
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
		System.out.println("Datei ï¿½ffnen ausgewï¿½hlt");
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
	
<<<<<<< HEAD
	public void setText(String str){
		taAnzeige.setText(str);
		revalidate();
	}
=======
	public void setText(String text){
		ta.setText(text);
	}
	
>>>>>>> branch 'master' of https://github.com/hammerniko/de.itg.hgs.oop.git

}
