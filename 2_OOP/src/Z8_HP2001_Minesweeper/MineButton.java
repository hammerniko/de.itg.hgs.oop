package Z8_HP2001_Minesweeper;

import javax.swing.JButton;

public class MineButton extends JButton {
	int x;
	int y;
	int wert;
	
	public static final int FREI = 0;
	public static final int MINE = -2;

	
	public MineButton(int x,int y){
		this.x = x;
		this.y = y;
		wert = FREI;
		setText(""+wert);
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getWert() {
		return wert;
	}


	public void setWert(int wert) {
		this.wert = wert;
	}
	
	

}
