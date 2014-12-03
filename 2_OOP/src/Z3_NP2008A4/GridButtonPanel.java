package Z3_NP2008A4;


import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GridButtonPanel {

    private static final int N = 6;
    private final List<MyButton> list = new ArrayList<MyButton>();

    private MyButton getGridButton(int x, int y) {
        int index = x * N + y;
        return list.get(index);
    }

    private MyButton createGridButton(final int x, final int y) {
        final MyButton b = new MyButton(x,y);
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                MyButton gb = GridButtonPanel.this.getGridButton(x, y);
                System.out.println("x=" + x + ",y="+y );
                
                   
            }
        });
        return b;
    }

    public JPanel createGridPanel() {
        JPanel p = new JPanel(new GridLayout(N, N));
        for (int i = 0; i < N * N; i++) {
            int x = i / N;
            int y = i % N;
            MyButton gb = createGridButton(x, y);
            list.add(gb);
            p.add(gb);
        }
        return p;
    }

    

   
}