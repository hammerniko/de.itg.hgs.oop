package C_OOPPasswortPrueferBidirektional;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectOutputStream.PutField;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Gui extends JFrame {
	//Assoziation
	Login derLogin;
	
	
	//Grafische Komponenten
	JPanel pContenPane;
	JPanel pEingabe;
	JPanel pButtons;
	JPanel pStatus;
	
	JLabel lbStatus;
	JButton btOk;
	JButton btCancel;
	JButton btBeenden;
	JTextField tfBenutzername;
	JPasswordField pfPasswort;
	JLabel lbBn;
	JLabel lbPw;

	
	String[] meldung;
	
	
	/**
	 * Konstruktor
	 * @param l
	 */
	public Gui(Login l) {
		//Assoziationen setzen
		derLogin = l;
		derLogin.linkGui(this);
		
		initText();
		
		initKomponents();
		
		aktualisiereStatus(0);
		
	}

	private void initText() {
		meldung = new String[3];
		
		meldung[0]="Bitte geben Sie Ihren Benutzernamen und das Passwort ein";
		meldung[1]="Passwort oder Benutzername ungültig";
		meldung[2]="Login erfolgreich";
		
		
		
	}

	private void initKomponents() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(500, 150);
		//this.setUndecorated(true);
		this.setLocation(500, 500);
		
		//Hauptcontainer
		pContenPane = new JPanel();
		pContenPane.setLayout(new BorderLayout());
		
		
		
		//Container für andere grafische Komponenten
		pEingabe = new JPanel();
		pButtons = new JPanel();
		pStatus = new JPanel();
		
		//Buttons
		btBeenden = new JButton("Exit");
		btBeenden.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clickedBeenden();
				
			}
		});

			
		
		btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clickedOk();
			}
		});
		
		btCancel = new JButton("Cancel");
		btCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clickedCancel();
				
			}
		});
		
		pButtons.add(btOk);
		pButtons.add(btCancel);
		pButtons.add(btBeenden);
		
		//Statuszeile
		lbStatus = new JLabel();
		JLabel lb1 = new JLabel("Status:");
		pStatus.add(lb1);
		pStatus.add(lbStatus);
		
		//Eingabefelder
		tfBenutzername = new JTextField(20);
		tfBenutzername.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pfPasswort.requestFocus();
				
			}
		});
		
		
		
		pfPasswort= new JPasswordField(20);
		pfPasswort.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clickedOk();
				
			}
		});
		
		
		
		lbBn = new JLabel("Username:");
		lbPw = new JLabel("Password:");
		pEingabe.setLayout(new BoxLayout(pEingabe, BoxLayout.Y_AXIS));
		
		pEingabe.add(lbBn);
		pEingabe.add(tfBenutzername);
		pEingabe.add(lbPw);
		pEingabe.add(pfPasswort);
		
		
		
		
		pContenPane.add(pButtons,BorderLayout.SOUTH);
		pContenPane.add(pEingabe,BorderLayout.CENTER);
		pContenPane.add(pStatus,BorderLayout.NORTH);
		
		this.setContentPane(pContenPane);
		
		
		//setOpacity(0.8f);
		setBackground(Color.orange);
		//setAlwaysOnTop(true);
		//setAutoRequestFocus(true);
		
	}

	public void aktualisiereStatus(int meldungNr){
		lbStatus.setText(meldung[meldungNr]);
	}
	
	private void clickedOk(){
		String name = tfBenutzername.getText();
		String pwd = pfPasswort.getText();
		
		derLogin.pruefeLogin(name, pwd);
		
		
		
	}
	
	private void clickedCancel(){
		tfBenutzername.setText("");
		pfPasswort.setText("");
		aktualisiereStatus(0);
	}
	
	private void clickedBeenden() {
		System.exit(0);
		
	}
	
}
