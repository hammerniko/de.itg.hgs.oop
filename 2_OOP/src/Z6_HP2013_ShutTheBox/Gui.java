package Z6_HP2013_ShutTheBox;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javafx.scene.layout.Border;

public class Gui extends JFrame {
	
	Steuerung dieSteuerung;
	
	JPanel jpLinks;
	JPanel jpRechts;
	JPanel jpSpieler1;
	JPanel jpSpieler2;
	JPanel jpWuerfel;
	JPanel jpButtons;
	JPanel jpKlappen;
	JPanel contentPane;
	JLabel lbName1;
	JLabel lbName2;
	JLabel lbPunkte1;
	JLabel lbPunkte2;
	JTextField tfName1;
	JTextField tfName2;
	JTextField tfPunkte1;
	JTextField tfPunkte2;
	JButton btWuerfeln;
	JButton btSpielerWechsel;
	JButtonKlappe bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9;
	
	JButtonWuerfel w1,w2;
	
	
	public static final String TITEL = "Shut the Box";
	private static final String WUERFELN = "würfeln";
	private static final String SPIELER_WECHSELN = "Spielerwechsel";
	
	public Gui(String pName1, String pName2) {
		dieSteuerung = new Steuerung(this);
		
		setTitle(TITEL);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		contentPane = new JPanel();
		jpLinks = new JPanel();
		jpRechts = new JPanel();
		jpSpieler1 = new JPanel();
		jpSpieler2 = new JPanel();
		jpWuerfel  = new JPanel();
		jpButtons = new JPanel();
		jpKlappen = new JPanel();
		
		lbName1 = new JLabel("Name1:");
		lbName2 = new JLabel("Name2:");
		lbPunkte1 = new JLabel("Punkte1:");
		lbPunkte2 = new JLabel("Punkte2:");
		tfName1 = new JTextField(10);
		tfName2 = new JTextField(10);
		tfPunkte1= new JTextField(4);
		tfPunkte2= new JTextField(4);
		btWuerfeln = new JButton(WUERFELN);
		btSpielerWechsel= new JButton(SPIELER_WECHSELN);
		bt1 = new JButtonKlappe(1);
		bt2 = new JButtonKlappe(2);
		bt3 = new JButtonKlappe(3);
		bt4 = new JButtonKlappe(4);
		bt5 = new JButtonKlappe(5);
		bt6 = new JButtonKlappe(6);
		bt7 = new JButtonKlappe(7);
		bt8 = new JButtonKlappe(0);
		bt9 = new JButtonKlappe(9);
		
		w1 = new JButtonWuerfel(6);
		w2 = new JButtonWuerfel(5);
		
		contentPane.setLayout(new BorderLayout());
		contentPane.add(jpLinks,BorderLayout.WEST);
		contentPane.add(jpRechts,BorderLayout.CENTER);
		
		
		jpRechts.setLayout(new BorderLayout());
		jpRechts.add(jpKlappen,BorderLayout.CENTER);
		jpRechts.add(jpButtons,BorderLayout.SOUTH);
		
		jpButtons.setLayout(new FlowLayout());
		jpButtons.add(btWuerfeln);
		jpButtons.add(btSpielerWechsel);
		jpButtons.add(jpWuerfel);
		jpWuerfel.setLayout(new FlowLayout());
		jpWuerfel.add(w1);
		jpWuerfel.add(w2);
		
		
		
		jpKlappen.setLayout(new FlowLayout());
		jpKlappen.add(bt1);
		jpKlappen.add(bt2);
		jpKlappen.add(bt3);
		jpKlappen.add(bt4);
		jpKlappen.add(bt5);
		jpKlappen.add(bt6);
		jpKlappen.add(bt7);
		jpKlappen.add(bt8);
		jpKlappen.add(bt9);
				
		setContentPane(contentPane);
		pack();
		
		btWuerfeln.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				klickWuerfeln();
				
			}
		});
		
		btSpielerWechsel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				klickWechsleSpieler();
				
			}
		});
		
	}
	
	public void zeigePunkte(int pIdxSpieler, int pMinusPunkte) {
		
	}
	
	public void oeffneAlleKlappen() {
		
	}
	
	public void schliesseKlappe(int pWert) {
		
	}
	
	public void aktiviereWuerfelTaste() {
		
	}
	
	public void aktiviereWechselTaste() {
		
	}

	public void klickWechsleSpieler() {
		
	}
	
	public void klickWuerfeln() {
		System.out.println("Wuerfeln geklickt");
		dieSteuerung.wuerfeln();
		
	}

	public void zeichneWuerfel(int wert1, int wert2) {
		w1.setWert(wert1);
		w2.setWert(wert2);
		
		w1.revalidate();
		w2.revalidate();
		w1.repaint();
		w2.repaint();
		
	}
}
