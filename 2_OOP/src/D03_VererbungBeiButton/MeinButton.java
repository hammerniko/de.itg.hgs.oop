package D03_VererbungBeiButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MeinButton extends JButton implements ActionListener{
    
	
	private static final int SPIELER_1  = -1;
	private static final int SPIELER_2  = 1;
	private static final int LEER  = 0;
	
    private int wert;
    
    public int getWert() {
        return wert;
    }

    public void setWert(int wert) {
        this.wert = wert;
    }

    public MeinButton(){
        wert =SPIELER_1;
        setZustand();
        addActionListener(this);
    }

    private void setZustand() {
        switch (wert) {
        case SPIELER_1: setText("X"); break;
        case SPIELER_2: setText("O");break;
        case LEER: setText("");break;


        default:
            break;
        }
        
        revalidate();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("action");
        wert = wert * -1;
        setZustand();
        
        repaint();
        
    }
    
    

}
