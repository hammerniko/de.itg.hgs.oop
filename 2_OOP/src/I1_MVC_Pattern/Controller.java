package I1_MVC_Pattern;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class Controller implements ActionListener,UpAndDown {
     
    private DecInc decinc; 
    private View view, view2, view3;
     
    public Controller(){
        // mein Model
        this.decinc = new DecInc();
        // meine Views
        this.view = new View(this);
        this.view2 = new View(this);
        this.view3 = new View(this);
         
        // Observer zu den Modellen hinzufügen.
        this.decinc.addObserver(this.view);
        this.decinc.addObserver(this.view2);
        this.decinc.addObserver(this.view3);
        this.view.setVisible(true);
        this.view2.setVisible(true);
        this.view3.setVisible(true);
    }
     
    @Override
    public void actionPerformed(ActionEvent arg0) {
        System.out.println("ACTION: " + arg0.getActionCommand().toString());
        if(arg0.getActionCommand().equalsIgnoreCase(ACTION_DEC))
            this.decinc.dec();
        if(arg0.getActionCommand().equalsIgnoreCase(ACTION_INC))
            this.decinc.inc();
    }
     
}