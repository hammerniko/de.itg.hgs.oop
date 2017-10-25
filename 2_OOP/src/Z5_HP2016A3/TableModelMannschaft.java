package Z5_HP2016A3;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class TableModelMannschaft extends AbstractTableModel {

	private String[] columNames = { "Index", "Mannschaft" };
	private Mannschaft[] mannschaften;

	private int anzahlMannschaften;

	public TableModelMannschaft(Mannschaft[] dieMannschfaft) {
		anzahlMannschaften = dieMannschfaft.length;
		mannschaften = dieMannschfaft;
	}

	@Override
	/**
	 * Es gibt soviele Spalten wie in dem String-Array columNames eingetragen sind
	 */
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columNames.length;
	}

	@Override
	/**
	 * Es werden x Mannschaftszeilen angezeigt
	 */
	public int getRowCount() {
		// TODO Auto-generated method stub
		return anzahlMannschaften;
	}

	@Override
	/**
	 * Nur die Spalte 1 ist editierbar
	 */
	public boolean isCellEditable(int rowIndex, int colIndex) {
		return colIndex == 1;
	}

	@Override
	/**
	 * Setze die Spaltennamen so wie sie im Array columnNames definiert sind.
	 */
	public String getColumnName(int col) {
		return columNames[col];
	}

	@Override
	/**
	 * Setze den Index der Mannschaft in die erste Spalte In der 2.ten Spalte stehen
	 * die Platzhalter für die Mannschaftsnamen.
	 */
	public Object getValueAt(int row, int col) {

		if (col == 0) {
			return "" + row;
		} else {
			return mannschaften[row].gibName();
		}

	}

	@Override
	public void setValueAt(Object value, int row, int col) {

		mannschaften[row].eintragenName("" + value);
		//fireTableCellUpdated(row, col);
	}

}
