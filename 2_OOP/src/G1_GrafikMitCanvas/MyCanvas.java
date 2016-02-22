package G1_GrafikMitCanvas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;


public class MyCanvas extends Canvas {
   
    public MyCanvas() {
     
    }

    public void paint(Graphics g) {
      
      g.setColor(Color.BLUE);
      g.drawLine(0,0,50,50);
      g.setColor(Color.red);
      g.fillRect(20,20,100,100);
      
    }
   
  }