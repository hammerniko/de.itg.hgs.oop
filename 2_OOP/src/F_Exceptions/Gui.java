package F_Exceptions;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Gui extends JFrame {
	
	JPanel contentPane;
	JTextField textfield;
	JLabel label;
	JButton btEingabe;
	
	public Gui(){
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setLayout(new FlowLayout());
		setContentPane(contentPane);
		
		textfield = new JTextField(10);
		label = new JLabel("Wuerfelzahl");
		btEingabe = new JButton("Übernehmen");
		btEingabe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonUebernehmenGeklickt();
			}
		});
				
		contentPane.add(label);
		contentPane.add(textfield);
		contentPane.add(btEingabe);
		
		pack();
	}

	
	protected void buttonUebernehmenGeklickt() {
		System.out.println("Übernehmen geklickt");
	
			try {
				int zahl = Integer.parseInt(textfield.getText());
				zeigeWuerfelzahl(zahl);
			} catch (WuerfelOutOfRangeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "Nur Zahlen von 1 bis 6 erlaubt");
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Nur Zahlen erlaubt");
				e.printStackTrace();
			}
			
	}


	private void zeigeWuerfelzahl(int zahl) throws WuerfelOutOfRangeException{
		if(zahl>=1 && zahl <=6){
			System.out.println(zahl);
		}
		else{
			throw new WuerfelOutOfRangeException();
		}
	}


	public static void main(String[] args){
		Gui gui = new Gui();
		gui.setVisible(true);
	}


	

}
