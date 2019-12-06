package G5_JTableModelDemo;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
 
public class JTableDemo{
	public static void main( String[] args ){
		// Unser TableModel (siehe unten)
		final Model model = new Model();
 
		// Das JTable initialisieren
		JTable table = new JTable( model );
 
		// Buttons, damit das alles schoener aussieht.
		final JButton buttonVehicel = new JButton( "add vehicel" );
 
		// Den Buttons ein paar Reaktionen geben
		buttonVehicel.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// Die Anzahl Columns (Breite) der Tabelle
				int size = model.getRowCount();
 
				// einen neuen Vector mit Daten herstellen
				Vehicel vehicel = createVehicel( size );
 
				// ein neues Vehikel hinzufuegen
				model.addVehicle( vehicel );
			}
		});
 
		JFrame frame = new JFrame( "Demo" );
 
		Container content = frame.getContentPane();
 
		content.add( new JScrollPane( table ), BorderLayout.CENTER );
		content.add( buttonVehicel, BorderLayout.SOUTH );
 
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.pack();
		frame.setVisible( true );
	}
 
	// Stellt einfach eine neue Instanz eines Vehikels her.
	public static Vehicel createVehicel( int index ){
		index = index % 5; // Modulo
 
		switch( index ){
			case 0: return new Vehicel( "Fahrrad", 1, 2, false );
			case 1: return new Vehicel( "Bus", 20, 4, true );
			case 2: return new Vehicel( "Pferd", 1, 0, false );
			case 3: return new Vehicel( "Zug", 1000, 80, true );
			case 4: return new Vehicel( "Truck", 2, 10, true );
			default: return null;	
		}
 
	}
}