package Z3_NP2008A4;


import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.ReverbType;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class GridButtonPanel {
	private JPanel p;
    private static final int N = 6;
    private final List<MyButton> buttons = new ArrayList<MyButton>();

    public MyButton getGridButton(int x, int y) {
        int index = x * N + y;
        return buttons.get(index);
    }

    private MyButton createGridButton(final int x, final int y) {
        final MyButton b = new MyButton(x,y);
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                MyButton gb = GridButtonPanel.this.getGridButton(x, y);
                
                //Wenn nur ein Frame existiert, kann so
                //einfach der Parent-Frame geholt werden
                //Sonst mit der Methode getInvoker(); lösen.
                Benutzeroberflaeche bo= (Benutzeroberflaeche) JFrame.getFrames()[0];  
                bo.feldClick(gb.getFeld());
                
                //System.out.println("x=" + x + ",y="+y );
                
                   
            }
        });
        return b;
    }

    public JPanel createGridPanel() {
        p = new JPanel(new GridLayout(N, N));
        for (int i = 0; i < N * N; i++) {
            int x = i / N;
            int y = i % N;
            MyButton gb = createGridButton(x, y);
            buttons.add(gb);
            p.add(gb);
        }
        return p;
    }

    public void setButtonData(Feld[] feld){
    	for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).setFeld(feld[i]);
			buttons.get(i).setBackground(feld[i].getFarbe());
			//System.out.println(feld[i]);
			
		}
    	
    	
    }
    
   
   
}