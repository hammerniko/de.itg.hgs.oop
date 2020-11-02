package D03_VererbungBeiButton;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MeinButton extends JButton implements ActionListener{
    
	
	private static final int SPIELER_1  = -1;
	private static final int SPIELER_2  = 1;
	private static final int LEER  = 0;
	private static final int ICON_SIZE=100;
	
	private ImageIcon icon;
	private ImageIcon iconX;
	private ImageIcon iconO;
    private int wert;
    
    public int getWert() {
        return wert;
    }

    public void setWert(int wert) {
        this.wert = wert;
    }

    public MeinButton(){
    	iconX = new ImageIcon("src//D03_VererbungBeiButton//x.jpg");
    	iconO = new ImageIcon("src//D03_VererbungBeiButton//o.jpg");
    	scaleIcon(iconX); 
    	scaleIcon(iconO); 
    	
        wert =SPIELER_1;
        setBorder(null);
        
        setZustand();
        addActionListener(this);
    }

	private void scaleIcon(ImageIcon icon) {
		icon.setImage(icon.getImage().getScaledInstance(ICON_SIZE,ICON_SIZE,Image.SCALE_DEFAULT));
	}

    private void setZustand() {
        switch (wert) {
        case SPIELER_1: setIcon(iconX);  break;
        case SPIELER_2: setIcon(iconO);break;
        case LEER: setIcon(null);break;

        default:
            break;
        }
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	
        System.out.println("action");
        wert = wert * -1;
        setZustand();
        
        revalidate();
        repaint();
        getParent().revalidate();
        
    }
    
   
    
    

}
