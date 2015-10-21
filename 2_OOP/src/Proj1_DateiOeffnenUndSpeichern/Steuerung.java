package Proj1_DateiOeffnenUndSpeichern;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
 
public class Steuerung {

	//Assoziation auf 
	Gui dieGui;
	TextFile tf;
	
	public Steuerung(Gui gui) {
		dieGui = gui;
		tf = new TextFile();
	}

	public void openFile() {
		System.out.println("Datei Oeffnen in Steuerung aufgerufen.");
		dieGui.setText(tf.openTextFile());

	}

	public void saveFile() {
		System.out.println("Datei Speichern in Steurung aufgerufen");
		

	}

}
