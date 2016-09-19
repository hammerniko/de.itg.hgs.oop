package A10_KlassenUndObjekteMitGui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GuiPasswort extends JFrame  {

	//Konstanten
	public static final String OK 		= "Passwort ok";
	public static final String NOT_OK 	= "Passwort falsch";
	public static final String STATUS 	= "Status:";
	public static final String PWD 		= "Passwort:";
	
    // Objekte fuer die Gui deklarieren
    JPanel contentPane;
    JLabel label1, label2;
    JLabel lbStatus;
    JPasswordField pfPasswort;
    Passwortpruefer passwortPruefer;

    // Konstruktor
    public GuiPasswort() {
        // Assoziation zu Passwortpruefer
        passwortPruefer = new Passwortpruefer();

        // Schliessverhalten und Groesse
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(200, 100);

        // Objekte erzeugen
        contentPane = new JPanel();
        label1 		= new JLabel(PWD);
        label2 		= new JLabel(STATUS);
        lbStatus 	= new JLabel();
        
        pfPasswort = new JPasswordField();
        pfPasswort.setColumns(5);
        pfPasswort.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 if (passwortPruefer.pruefePasswort(pfPasswort.getText())) {
		                System.out.println(OK);
		                lbStatus.setText(OK);
		                
		                GuiHauptprogramm dasHP = new GuiHauptprogramm();
		                dasHP.setVisible(true);
		                dispose();
		                passwortPruefer = null;
		                
		            } else {
		                System.out.println(NOT_OK);
		                lbStatus.setText(NOT_OK);
		            }
				
			}
		});

        // Layout fuer die Contentpane
        contentPane.setLayout(new GridLayout(2, 2));

        // Komponenten zur Contentpane hinzufuegen
        contentPane.add(label1);
        contentPane.add(pfPasswort);
        contentPane.add(label2);
        contentPane.add(lbStatus);

        // Contenpane des JFrame setzen
        setContentPane(contentPane);

    }

    

}
