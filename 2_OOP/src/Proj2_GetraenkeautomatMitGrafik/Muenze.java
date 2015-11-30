package Proj2_GetraenkeautomatMitGrafik;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Muenze extends JLabel implements ActionListener{
	
	ImageIcon bild;
	int muenzwert;
	int anzahl;

	public Muenze(int wert){
		anzahl = 1;
		setMuenze(wert);
	}
	
	public void setMuenze(int wert){
	String bildname = "";
	switch (wert) {
	case 1:
	case 2:
	case 5:
	case 10:
	case 20:
	case 50:
		bildname = wert+"Cent.jpg"; break;
	case 100:
	case 200:
		bildname = (wert/100)+"Euro.jpg"; break;
	
	}
		

	setIcon(new ImageIcon(getClass().getResource(bildname)));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		anzahl++;
		
	}

}
