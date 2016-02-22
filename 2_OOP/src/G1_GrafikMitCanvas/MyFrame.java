package G1_GrafikMitCanvas;

import javax.swing.JFrame;

public class MyFrame extends JFrame {

	public MyFrame() {
		createGui();
	}

	private void createGui() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(300,300);
		
		MyCanvas myCanvas = new MyCanvas();
		add(myCanvas);

	}

}