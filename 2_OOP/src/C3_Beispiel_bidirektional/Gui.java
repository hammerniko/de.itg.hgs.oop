package C3_Beispiel_bidirektional;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui extends JFrame {
	
	//Assoziation
	private Steuerung dieSteuerung;
	
	//Komponenten
	private JPanel contentPane;
	private JPanel pAnzeige;
	private JPanel pButtons;
	private JLabel lbName;
	private JLabel lbBeschriftungName;
	private JButton btOk;
	private JButton btAbbrechen;

	public Gui(Steuerung s) {

		//Assoziation setzen
		dieSteuerung = s;
		
		contentPane = new JPanel();
		pAnzeige = new JPanel();
		pButtons = new JPanel();
		btOk = new JButton("Ok");
		btAbbrechen = new JButton("Abbrechen");
		lbName = new JLabel("...");
		lbBeschriftungName = new JLabel("Schueler:");
				
		//Layout
		contentPane.setLayout(new BorderLayout());
		contentPane.add(pAnzeige, BorderLayout.CENTER);
		contentPane.add(pButtons, BorderLayout.SOUTH);
		
		pAnzeige.add(lbBeschriftungName);
		pAnzeige.add(lbName);
		
		pButtons.add(btOk);
		pButtons.add(btAbbrechen);
		
		
		//Settings
		this.setContentPane(contentPane);
		this.setSize(300,300);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("Schuelerdaten lesen");
		
		//Listener
		btOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clickedButtonOk();
				
			}
		});
		
		
		
		
		btAbbrechen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clickedButtonAbbrechen();
				
			}
		});

	}
	
	protected void clickedButtonOk() {
		System.out.println("clickedButtonOK");
		dieSteuerung.clickedOK();
		
	}

	private void clickedButtonAbbrechen() {
		System.out.println("ClickedButtonAbbrechen");
		lbName.setText("");
		
	}

	
	public void zeigeSchueler(String string) {
		lbName.setText(string);
		
	}

}
