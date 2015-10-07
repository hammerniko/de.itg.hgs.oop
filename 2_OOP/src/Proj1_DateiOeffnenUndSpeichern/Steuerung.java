package Proj1_DateiOeffnenUndSpeichern;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;

public class Steuerung {

	// Assoziation
	Gui dieGui;

	public Steuerung(Gui gui) {
		dieGui = gui;
	}

	public void dateiOeffnen() {
		System.out.println("Datei Oeffnen in Steuerung aufgerufen.");
		JFileChooser fc = new JFileChooser();
		int auswahl = fc.showOpenDialog(dieGui);

		if (auswahl == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();

			try {
				FileInputStream fis = null;
				BufferedInputStream bis = null;
				DataInputStream dis = null;

				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				dis = new DataInputStream(bis);

				String str="";
				
				while (dis.available() != 0) {
					str = str+"\n"+ dis.readLine();
				}
				fis.close();
				bis.close();
				dis.close();
				dieGui.setText(str);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void dateiSpeichern() {
		System.out.println("Datei Speichern in Steurung aufgerufen");
		JFileChooser fc = new JFileChooser();
		fc.showSaveDialog(dieGui);

	}

}
