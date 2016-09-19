package G3_TabelleEinfach;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JLabel;

public class TestJTable extends JFrame implements ActionListener, KeyListener,
		MouseListener {

	private String letzteEingabe = null;
	private JPanel jContentPane = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	private JPanel jPanel = null;
	private JButton jButton = null;
	private JLabel jLabelStatus = null;

	/**
	 * This is the default constructor
	 */
	public TestJTable() {
		super();
		initialize();
		letzteEingabe = "";
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(334, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelStatus = new JLabel();
			jLabelStatus.setText("Meldung:");
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJScrollPane(), java.awt.BorderLayout.CENTER);
			jContentPane.add(getJPanel(), java.awt.BorderLayout.NORTH);
			jContentPane.add(jLabelStatus, java.awt.BorderLayout.SOUTH);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jScrollPane
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTable
	 * 
	 * @return javax.swing.JTable
	 */
	private JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable(3, 3);
		jTable.setCellSelectionEnabled(true);
			jTable.setRowSelectionAllowed(false);
			jTable.setColumnSelectionAllowed(false);
			jTable.setValueAt("abc", 0, 0);
			jTable.addKeyListener(this);
			jTable.addMouseListener(this);
		}
		return jTable;
	}

	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.add(getJButton(), null);
		}
		return jPanel;
	}

	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("ok");
			jButton.addActionListener(this);
		}
		return jButton;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(jButton)) {
			int row = jTable.getSelectedRow();
			int col = jTable.getSelectedColumn();

			if (jTable.getValueAt(row, col) == null) {

				jTable.setValueAt(letzteEingabe, row, col);
				
			} else {
				jTable.setValueAt(jTable.getValueAt(row,col)+letzteEingabe,row,col);
			}
			jLabelStatus.setText("Übernommen:" + jTable.getValueAt(row, col));
			jTable.revalidate();
			this.repaint();
			

		}
		// TODO Automatisch erstellter Methoden-Stub

	}

	public void keyTyped(KeyEvent ke) {
		
		letzteEingabe = letzteEingabe + ke.getKeyChar();
		jLabelStatus.setText(letzteEingabe);

	}

	public void keyPressed(KeyEvent ke) {
		// TODO Automatisch erstellter Methoden-Stub

	}

	public void keyReleased(KeyEvent ke) {
		// TODO Automatisch erstellter Methoden-Stub

	}

	public void mouseClicked(MouseEvent e) {
		letzteEingabe = "";
		jLabelStatus.setText("letzteEingabe gelöscht");
	}

	public void mousePressed(MouseEvent e) {
		letzteEingabe = "";
		jLabelStatus.setText("letzteEingabe gelöscht");

	}

	public void mouseReleased(MouseEvent me) {
		// TODO Automatisch erstellter Methoden-Stub

	}

	public void mouseEntered(MouseEvent me) {

	}

	public void mouseExited(MouseEvent me) {
		// TODO Automatisch erstellter Methoden-Stub

	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
