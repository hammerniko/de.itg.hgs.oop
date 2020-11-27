package L3_ASternMitGui;


import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;


public class Mouse extends MouseInputAdapter{
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		//Mausposition wird ermittelt und konvertiert
		Point mousePos = new Point(e.getX(), e.getY());
		Frame.Screen.convertToTilePos(mousePos);
		
		//Bei Linksklick wird das Tile auf Wand gesetzt
		if(SwingUtilities.isLeftMouseButton(e)){ //Überprüfung ob die linke Maustaste gedrückt wurde
			if(Frame.setWalls){
				Frame.Screen.setTileType((short) mousePos.x, (short) mousePos.y, Frame.Screen.WALL);
				Frame.Screen.resetPath();
				Frame.screen.repaint();
			}else{
				Frame.Screen.setNewStartPos(mousePos);
				Frame.screen.repaint();
			}
			
			
		//Bei Rechtsklick wird das Tile geleert
		}else if(SwingUtilities.isRightMouseButton(e)){
			if(Frame.setWalls){
				Frame.Screen.setTileType((short) mousePos.x, (short) mousePos.y, Frame.Screen.EMPTY);
				Frame.Screen.resetPath();
				Frame.screen.repaint();
			}else{
				Frame.Screen.setNewTargPos(mousePos);
				Frame.screen.repaint();
			}
			
		}
	}
	
	
	//Methode die die derzeitige Mausposition
	public static Point getPos(){
		Point mousePos = MouseInfo.getPointerInfo().getLocation();
		SwingUtilities.convertPointFromScreen(mousePos, Frame.screen);
		return mousePos;
	}
	
}
