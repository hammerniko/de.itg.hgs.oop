package C_OOPLoginOhneButtons;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Gui extends JFrame {
	
	//Assoziation
	Steuerung dieSteuerung;
	
	JPanel contentPane;
	JTextField tfBN;
	JPasswordField pfKW;
	JLabel lbBN;
	JLabel lbKW;
	JLabel lbStatus;
	JPanel pStatus;
	JPanel pAnzeige;
	
	public Gui(Steuerung s) {
		
		dieSteuerung = s;
		
		contentPane = new JPanel();
		pAnzeige = new JPanel();
		pStatus = new JPanel();
		
		lbBN = new JLabel("Benutzername:");
		lbKW = new JLabel("Kennwort:");
		lbStatus = new JLabel("Status:");
		
		tfBN = new JTextField(10);
		pfKW = new JPasswordField(10);
		
		pAnzeige.setLayout(new GridLayout(2,2));
		
		pAnzeige.add(lbBN);
		pAnzeige.add(tfBN);
		pAnzeige.add(lbKW);
		pAnzeige.add(pfKW);
		
		pStatus.add(lbStatus);
		pStatus.setLayout(new FlowLayout());
		
		
		
		pStatus.add(lbStatus);
		contentPane.setLayout(new BorderLayout());
		contentPane.add(pAnzeige, BorderLayout.CENTER);
		contentPane.add(pStatus, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setContentPane(contentPane);
		setVisible(true);
		setTitle("Login MyApp");
		pack();
		
		tfBN.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				enteredBN();
				
			}
		});
		
		pfKW.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				enteredKW();
				
			}
		});
		
	}

	protected void enteredKW() {
		String kw = pfKW.getText();
		dieSteuerung.pruefeKennwort(kw);
		
		
	}

	protected void enteredBN() {
		String bn = tfBN.getText();
		dieSteuerung.pruefeBenutzername(bn);
		
	}

	public void zeigeStatus(String meldung) {
		lbStatus.setText(meldung);
		
	}
	
	public void setzeFocusAufBN() {
		tfBN.requestFocus();
		tfBN.selectAll();
	}
	
	public void setzeFocusAufKW() {
		pfKW.requestFocus();
		pfKW.selectAll();
		
	}

}
