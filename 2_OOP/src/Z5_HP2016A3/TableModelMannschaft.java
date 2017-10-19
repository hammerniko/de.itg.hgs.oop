package Z5_HP2016A3;

import javax.swing.table.AbstractTableModel;

public class TableModelMannschaft extends AbstractTableModel {

	String[] columNames = {"Index","Mannschaft"};
	
	@Override
	/**
	 * Es gibt soviele Spalten wie in dem String-Array columNames
	 * eingetragen sind
	 */
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columNames.length;
	}

	@Override
	/**
	 * Es werden 6 Mannschaftszeilen angezeigt
	 */
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 6;
	}
	
	

	@Override
	/**
	 * Nur die Spalte 1 ist editierbar
	 */
	public boolean isCellEditable(int rowIndex, int colIndex) {
		return colIndex == 1; }

	@Override
	/**
	 * Setze die Spaltennamen so wie sie im Array columnNames
	 * definiert sind.
	 */
	public String getColumnName(int col) {
		return columNames[col];
	}

	@Override
	/**
	 * Setze den Index der Mannschaft in die erste Spalte
	 * In der 2.ten Spalte stehen die Platzhalter für
	 * die Mannschaftsnamen.
	 */
	public Object getValueAt(int row, int col) {
		if(col ==0 ) {
			return ""+row;
		}
		else  {
			return "Mannschaft"+row;
		}
		
	}

}
