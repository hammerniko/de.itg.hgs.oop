package Z2_NP2008A4_LoesungSchueler;

import java.awt.Color;
import javax.swing.JButton;

public class Button extends JButton{
	
	private int zeile;
	private int spalte;
	private int wert;
	private int idGruppe = 0;
	private Color farbe;
	private String text;

	public Button(int spalte, int zeile, int wert) {
		super();
		this.zeile = zeile;
		this.spalte = spalte;
		setWert(wert);
	}
	
	public Button(String text){
		this.text = text;
	}

	public int getZeile() {
		return zeile;
	}

	public void setZeile(int zeile) {
		this.zeile = zeile;
	}

	public int getSpalte() {
		return spalte;
	}

	public void setSpalte(int spalte) {
		this.spalte = spalte;
	}

	public int getWert() {
		return wert;
	}
	
	public void setWert(int wert){
		this.wert = wert;
		text = "" + wert;
	}

	public int getGruppe() {
		return idGruppe;
	}

	public void setGruppe(int idGruppe) {
		this.idGruppe = idGruppe;
	}

	public Color getFarbe() {
		return farbe;
	}

	public void setFarbe(Color farbe) {
		this.farbe = farbe;
		setBackground(farbe);
	}

	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Button[Zeile:" + zeile + ";Spalte:" + spalte + ";Wert:" + wert + ";Text:" + text + ";Gruppe:" + idGruppe + ";Farbe:" + farbe + "]";
	}
	
}
