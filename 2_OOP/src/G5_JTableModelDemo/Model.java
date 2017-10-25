package G5_JTableModelDemo;

import java.util.Vector;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

//Unsere Implementation des TableModels
class Model implements TableModel{
	private Vector vehicels = new Vector();
	private Vector listeners = new Vector();

	public void addVehicle( Vehicel vehicel ){
		// Das wird der Index des Vehikels werden
		int index = vehicels.size();
		vehicels.add( vehicel );

		// Jetzt werden alle Listeners benachrichtigt

		// Zuerst ein Event, "neue Row an der Stelle index" herstellen
		TableModelEvent e = new TableModelEvent( this, index, index, 
				TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT );

		// Nun das Event verschicken
		for( int i = 0, n = listeners.size(); i<n; i++ ){
			((TableModelListener)listeners.get( i )).tableChanged( e );
		}
	}

	// Die Anzahl Columns
	public int getColumnCount() {
		return 4;
	}

	// Die Anzahl Vehikel
	public int getRowCount() {
		return vehicels.size();
	}

	// Die Titel der einzelnen Columns
	public String getColumnName(int column) {
		switch( column ){
			case 0: return "Name";
			case 1: return "Fahrgäste";
			case 2: return "Räder";
			case 3: return "Besitzt Motor";
			default: return null;
		}
	}

	// Der Wert der Zelle (rowIndex, columnIndex)
	public Object getValueAt(int rowIndex, int columnIndex) {
		Vehicel vehicle = (Vehicel)vehicels.get( rowIndex );

		switch( columnIndex ){
			case 0: return vehicle.getName();
			case 1: return new Integer( vehicle.getPlaces() );
			case 2: return new Integer( vehicle.getWheels() );
			case 3: return vehicle.hasMotor() ? Boolean.TRUE : Boolean.FALSE; 
			default: return null;
		}
	}

	// Eine Angabe, welchen Typ von Objekten in den Columns angezeigt werden soll
	public Class getColumnClass(int columnIndex) {
		switch( columnIndex ){
			case 0: return String.class;
			case 1: return Integer.class;
			case 2: return Integer.class;
			case 3: return Boolean.class; 
			default: return null;
		}	
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		listeners.add( l );
	}
	
	@Override
	public void removeTableModelListener(TableModelListener l) {
		listeners.remove( l );
	}


	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// nicht beachten
	}

	
	

	

}