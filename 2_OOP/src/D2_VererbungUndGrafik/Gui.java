package D2_VererbungUndGrafik;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Gui extends JFrame{
	
	private static final String TITEL = "HGS Huhn";
	MoorhuhnPanel meinPanel;
	
	//Menukomponenten
	JMenuBar mb;
	JMenu menuDatei;
	JMenu menuTest;
	JMenu menuHilfe;
	JMenuItem menuItemOeffnen;
	JMenuItem menuItemEnde;
	JMenuItem menuItemTest;
	

	public Gui()  {
		initGui();
		initMenu();
	}

	private void initGui() {
		meinPanel =  new MoorhuhnPanel();
		setContentPane(meinPanel);
		setMaximized();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle(TITEL);
	}

	private void initMenu() {
		mb = new JMenuBar();
		menuDatei = new JMenu("Datei");	
		menuHilfe= new JMenu("Hilfe");	
		menuItemOeffnen = new JMenuItem("Oeffnen");
		menuTest = new JMenu("Test");
		menuItemTest = new JMenuItem("Test");
		
		menuItemEnde = new JMenuItem("Programmende");	
		menuTest.add(menuItemTest);
		menuDatei.add(menuTest);
		menuDatei.add(menuItemOeffnen);
		menuDatei.addSeparator();
		menuDatei.add(menuItemEnde);
		
		mb.add(menuDatei);
		mb.add(menuHilfe);
		
		menuItemOeffnen.setEnabled(false);
		setJMenuBar(mb);
		
		menuItemEnde.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clickedProgrammende();
			}
		});
	}

	protected void clickedProgrammende() {
		System.out.println("Programmende geklickt");
		System.exit(DISPOSE_ON_CLOSE);
	}

	private void setMaximized() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(dimension.width,dimension.height);
	}
	
	
	public static void main(String[] args){
		Gui gui = new Gui();
		gui.setVisible(true);
	}
	
	//WindowListener registrieren
	private void registerWindowListener() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				clickedProgrammende();
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
					//Spiel fortsetzen
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				//Spiel pausieren
			}
		});
		
	}

	
}
