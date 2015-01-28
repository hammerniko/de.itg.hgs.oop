package Z2_NP2008A4_LoesungSchueler;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.GridLayout;

public class Gui extends JFrame {

	Steuerung dieSteuerung;

	JFrame mainWindow;
	JSplitPane splittPanel;
	JPanel buttonPanel;
	JPanel anzeigePanel;
	Button btnRestart;
	Button btn[][] = new Button[6][6];
	JLabel lbAnzeige;
	String[] textAusgabe = {
			"Klicke zusammenhaengende Felder an, die in einer Gruppe die Summe 15 ergeben.",
			"Neue Gruppe!",
			"Gruppe erweitert.",
			"15 sind voll!",
			"Welcher Gruppe soll dass Feld zugeordnet werden? Klicke auf Gruppe!",
			"Beide schon in einer Gruppe!", "Übersteigt 15!", "Nicht anliegend!" };

	int x, y = 50;


	public Gui(Steuerung dieSteuerung) {

		this.dieSteuerung = dieSteuerung;
		setTitle("Fuenfzehn");
		GridLayout dasgGridLayout = new GridLayout(6, 6);
		splittPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		buttonPanel = new JPanel();
		anzeigePanel = new JPanel();
		mainWindow = new JFrame();
		btnRestart = new Button("Restart");
		btnRestart.addMouseListener(new MouseClicked(this, btnRestart));
		lbAnzeige = new JLabel(textAusgabe[0]);
		lbAnzeige.setFont(new Font("Arial Black", Font.BOLD, 14));
		lbAnzeige.setHorizontalAlignment(SwingConstants.CENTER);

		mainWindow.setResizable(false);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setSize(1500, 700);
		mainWindow.setLocationRelativeTo(mainWindow);
		mainWindow.setVisible(true);

		mainWindow.getContentPane().add(splittPanel);
		buttonPanel.setLayout(dasgGridLayout);
		anzeigePanel.setLayout(null);
		btnRestart.setBounds(300, 10, 150, 75);
		lbAnzeige.setBounds(12, 100, 718, 100);

		anzeigePanel.add(lbAnzeige);
		anzeigePanel.add(btnRestart);

		splittPanel.setLeftComponent(buttonPanel);
		splittPanel.setRightComponent(anzeigePanel);
		splittPanel.setDividerLocation(750);
		splittPanel.setDividerSize(1);
		splittPanel.setEnabled(false);

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				int zZahl = dieSteuerung.zufallsZahl();
				btn[i][j] = new Button(i, j, zZahl);
				btn[i][j].addMouseListener(new MouseClicked(this, btn[i][j]));
				buttonPanel.add(btn[i][j]);
			}
		}
	}

	public void resetField() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				int zZahl = dieSteuerung.zufallsZahl();
				btn[i][j].setWert(zZahl);
				btn[i][j].setFarbe(null);
				btn[i][j].setGruppe(0);
				btn[i][j].setVisible(true);
			}
		}
		buttonPanel.repaint();
	}
	
	public void mouseClicked(Button btn){
		dieSteuerung.btncheck(btn);
	}
	
	public void resetClicked(){
		dieSteuerung.reset();
	}

	public void setAnzeige(int zahl) {
		lbAnzeige.setText(textAusgabe[zahl]);
	}
}
