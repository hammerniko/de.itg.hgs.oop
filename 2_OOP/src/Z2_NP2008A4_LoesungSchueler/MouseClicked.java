package Z2_NP2008A4_LoesungSchueler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseClicked implements MouseListener {

	Gui parent;
	int btnzahl;
	Button btn;

	public MouseClicked(Gui gui, Button btn) {
		parent = gui;
		this.btn = btn;
	}

	public void mouseClicked(MouseEvent mouseClick) {
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("-----Mausklick erkannt:" + btn.toString() + "-----");
		if (btn.getText() == "Restart") {
			parent.resetClicked();
		} else {
			parent.mouseClicked(btn);
		}

	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}