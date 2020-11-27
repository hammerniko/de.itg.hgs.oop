package L3_ASternMitGui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class Keyboard extends KeyAdapter{
	
	@Override
	public void keyPressed(KeyEvent e){
		//Beim drücken der Leertaste wird ein Teilschritt des Weges gesucht
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			Frame.Screen.findPath(false);
		//Beim drücken von Enter wird der gesamte Weg berechnet
		}else if(e.getKeyCode() == KeyEvent.VK_ENTER){
			Frame.Screen.findPath(true);
		}
	}
}
