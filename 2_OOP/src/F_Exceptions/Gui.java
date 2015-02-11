package F_Exceptions;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Einfache Oberfl�che zur Demonstration von Exceptions.
 * In das Textfeld soll eine W�relzahl eingegeben werden.
 * Wird statt einer Zahl Buchstabe eingegeben, wirft die Methode
 * {@link #zeigeWuerfelzahl(int)} eine NumberformatException.
 * Wird eine ung�ltige Zahl die kleiner 1 oder gr��er 6 ist eingegeben,
 * wird eine selbst erzeugte Exception geworfen.
 * 
 * @author hr
 *
 */
public class Gui extends JFrame {
	/**
	 * Hauptcontainer des Fensters
	 */
	JPanel contentPane;
	
	/**
	 * Textfeld zur Eeingabe der Wuerfelzahl
	 */
	JTextField textfield;
	JLabel label;
	
	/**
	 * Button um die Eingebene Ziffer zu �bernehmen.
	 * Durch einen klick auf diesen Button, wird die 
	 * Methode {@link #buttonUebernehmenGeklickt()} 
	 * aufgerufen
	 */
	JButton btEingabe;
	
	/**
	 * Standardkonstruktor der Gui
	 */
	public Gui(){
		
		/**
		 * Sorgt daf�r das der Prozess beendet wird, mit welchem das
		 * Gui Objekt erstellt wurde, wenn man auf die Schaltfl�che Schliessen
		 * des Fensters klickt.
		 */
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		/**
		 * Das JPanel Objekt f�r den Hauptcontainer
		 * wird erzeugt.
		 */
		contentPane = new JPanel();
		
		/**
		 * Das Layout f�r den Hauptcontainer wird auf Flowlayout gestellt.
		 * Dies bewirkt, das alle Komponenten nebeneinander mit einem
		 * definierten Abstand platziert werden.
		 */
		contentPane.setLayout(new FlowLayout());
		
		
		/**
		 * Hier wird dem JFrame Objekt gesagt, welches JPanel
		 * Objekt der Hauptcontainer sein soll.
		 */
		setContentPane(contentPane);
		
		
		/**
		 * Ein Textfeld mit einer Breite von 10 Spalten
		 * wird erzeugt, um eine W�rfelzahl eingeben zu k�nnen.
		 */
		textfield = new JTextField(10);
		label = new JLabel("Wuerfelzahl");
		
		/**
		 * Ein Objekt des �bernehmen Buttons wird erstellt.
		 */
		btEingabe = new JButton("�bernehmen");
		
		
		/**
		 * Der Button bekommt einen Actionlistener. Wird der Button geklickt,
		 * erzeugt er ein ActionEvent Objekt. In diesem Objekt sind die Daten des Klicks
		 * gespeichert. Also wer hat mich geklickt, wann wurde geklickt, wo wurde geklickt usw.
		 * Mit new ActionListener()... wird eine anonyme ActionListener Klasse mit
		 * einer implementierten actionPerformed()... Methode erzeugt.
		 * An diese Methode wird das erzeugte ActionEvent Objekt als parameter e
		 * �bergeben. Der Inhalt dieser Methode wird abgearbeitet, wenn der 
		 * Button geklickt wurde.
		 * Damit der Code �bersichtlicher bleibt, rufen wir an dieser Stelle
		 * die Methode @see {@link #buttonUebernehmenGeklickt()} aufgerufen,
		 * welche im Codeblock der Klasse steht.
		 */
		btEingabe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonUebernehmenGeklickt();
			}
		});
			
		/**
		 * Hinzuf�gen der Komponenten zum Hauptcontainer des Fensters.
		 * HIerbei ist die Reihenfolge zu beachten.
		 */
		contentPane.add(label);
		contentPane.add(textfield);
		contentPane.add(btEingabe);
		
		/**
		 * Stellt das erzeugte Fensterobjekt in der kleinstm�glichen
		 * Gr��e mit allen sichbaren Komponenten dar.
		 */
		pack();
	}

	
	/**
	 * @author hr
	 * Diese Methode wird aufgerufen wenn der Benutzer
	 * den Button mit der Beschriftung "Uebernehmen" 
	 * geklickt hat.
	 *  
	 */
	public void buttonUebernehmenGeklickt() {
		System.out.println("�bernehmen geklickt");
			
			try {
				int zahl = Integer.parseInt(textfield.getText());
				zeigeWuerfelzahl(zahl);
			} catch (WuerfelOutOfRangeException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "Nur Zahlen von 1 bis 6 erlaubt","Error",JOptionPane.ERROR_MESSAGE );
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Nur Zahlen erlaubt","Error",JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			
	}

	/**
	 * @param zahl
	 * ist die zu pr�fende Zahl
	 * 
	 * @throws WuerfelOutOfRangeException
	 * Diese Exception wird ausgeloest, wenn zahl
	 * nicht zwischen 1 und 6 liegt
	 */
	public void zeigeWuerfelzahl(int zahl) throws WuerfelOutOfRangeException{
		if(zahl>=1 && zahl <=6){
			System.out.println(zahl);
		}
		else{
			throw new WuerfelOutOfRangeException();
		}
	}

	/**
	 * Einstiegspunkt des Programms.
	 * Es wird ein Objekt der Gui erzeugt und
	 * sichtbar gemacht.
	 * 
	 * @param args
	 * wird hier nicht verwendet
	 */
	public static void main(String[] args){
		Gui gui = new Gui();
		gui.setVisible(true);
	}


	

}
