package Proj2_GetraenkeautomatMitGrafik;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

public class Gui extends JFrame{
	
	JPanel contentPane;
	JPanel rueckgabe;
	JPanel eingabe;
	JPanel info;
	Muenze muenzen[];
	JLabel anzMuenzen[];
	JLabel betrag;
	JLabel rueckgeld;
	JLabel labelBetrag;
	JLabel labelRueckgeld;
	
	public Gui(){
		
		setVisible(true);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.white);
		
		info = new JPanel();
		info.setBackground(Color.white);
		info.setLayout(new GridLayout(2,2));
		labelBetrag = new JLabel("Betrag:");
		betrag = new JLabel(""+0.0);
		labelRueckgeld = new JLabel("Retoure:");
		rueckgeld = new JLabel(""+0.0);
		info.add(labelBetrag);
		info.add(betrag);
		info.add(labelRueckgeld);
		info.add(rueckgeld);
				
		rueckgabe = new JPanel();
		rueckgabe.setBackground(Color.white);
		rueckgabe.setLayout(new GridLayout(2,8));
		
		eingabe = new JPanel();
		eingabe.setBackground(Color.white);
		
		//Labels Anzahl
		anzMuenzen = new JLabel[8];
		anzMuenzen[0] = new JLabel(""+0);
		anzMuenzen[1] = new JLabel(""+0);
		anzMuenzen[2] = new JLabel(""+0);
		anzMuenzen[3] = new JLabel(""+0);
		anzMuenzen[4] = new JLabel(""+0);
		anzMuenzen[5] = new JLabel(""+0);
		anzMuenzen[6] = new JLabel(""+0);
		anzMuenzen[7] = new JLabel(""+0);
		
		
		//Bilder
		muenzen = new Muenze[8];
		muenzen[0] = new Muenze(1);
		muenzen[1] = new Muenze(2);
		muenzen[2] = new Muenze(5);
		muenzen[3] = new Muenze(10);
		muenzen[4] = new Muenze(20);
		muenzen[5] = new Muenze(50);
		muenzen[6] = new Muenze(100);
		muenzen[7] = new Muenze(200);
		
		for (int i = 0; i < muenzen.length; i++) {
			rueckgabe.add(muenzen[i]);
			rueckgabe.add(anzMuenzen[i]);
			
		}
		
		contentPane.add(info,BorderLayout.NORTH);
		contentPane.add(rueckgabe, BorderLayout.CENTER);
		
		
		setContentPane(contentPane);
		setSize(1024,768);
	}

}
