package C_OOPPasswortPrueferBidirektional;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class GuiNeu extends JFrame {

	//Container für Meldungen
	String[] meldung;
	
	//Assoziation
	Login login;
	
	//Konstanten
	private static final String READY = "...";
	private static final int HEIGHT = 170;
	private static final int WIDTH = 450;
	private static final int BORDER = 5;
	private static final String PASSWORT = "Passwort:";
	private static final String BENUTZERNAME = "Benutzername:";
	public static final String TITEL = "Login";
	private static final String OK = "Ok";
	
	//Komponenten
	private JPanel contentPane;
	private JTextField textFieldBn;
	private JPasswordField passwordField;
	private JLabel lblBenutzername;
	private JLabel lblPasswort;
	private JButton btnOk;
	private JLabel lblStatustext;
	private JLabel lblStatus;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiNeu frame = new GuiNeu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiNeu() {
		setTitle(TITEL);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout();
		addListener();
		setAssoziation();
		initTextMeldungen();
		
		textFieldBn.requestFocus();
		
	}
	
	/**
	 * Initialisiere Textmeldungen fuer die Statuszeile
	 */
	private void initTextMeldungen() {
		meldung = new String[3];
		meldung[0]="Bitte geben Sie Ihren Benutzernamen und das Passwort ein";
		meldung[1]="Passwort oder Benutzername ungültig";
		meldung[2]="Login erfolgreich";
	}

	private void setAssoziation() {
		login = new Login(this);
	}

	private void addListener() {
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clickedBtnOk();
				
			}
		});
		
		textFieldBn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				enteredBenutzername();
				
			}
		});
		
		passwordField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				enteredPassword();
				
			}
		});
		
	}

	protected void enteredPassword() {
		clickedBtnOk();
		textFieldBn.requestFocus();
		
	}

	protected void enteredBenutzername() {
		passwordField.requestFocus();
		
	}

	protected void clickedBtnOk() {
		//Lese Benutzername
		String bn = textFieldBn.getText();
		
		//Lese Passwort
		String pw =  passwordField.getText();
		
		//Prüfe Passwort & Benutzername
		login.pruefeLogin(bn, pw);
		
	}

	private void setLayout() {
		setBounds(100, 100, WIDTH, HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(BORDER, BORDER, BORDER, BORDER));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][grow][]", "[][][]"));
		
		lblBenutzername = new JLabel(BENUTZERNAME);
		contentPane.add(lblBenutzername, "cell 1 0,alignx trailing");
		
		textFieldBn = new JTextField();
		contentPane.add(textFieldBn, "cell 2 0,growx");
		textFieldBn.setColumns(10);
		
		lblPasswort = new JLabel(PASSWORT);
		contentPane.add(lblPasswort, "cell 1 1,alignx trailing");
		
		passwordField = new JPasswordField();
		contentPane.add(passwordField, "cell 2 1,growx");
		passwordField.setColumns(10);
		
		lblStatustext = new JLabel("Status:");
		contentPane.add(lblStatustext, "cell 1 3,alignx trailing");
		
		lblStatus = new JLabel(READY);
		contentPane.add(lblStatus, "cell 2 3");
		
		btnOk = new JButton(OK);
		contentPane.add(btnOk, "cell 11 8");
	}
	
	public void aktualisiereStatus(int meldungNr){
		lblStatus.setText(meldung[meldungNr]);
	}
}
