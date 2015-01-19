package Z2_NP2008A4_LoesungSchueler;

import java.awt.Color;
import java.util.Vector;

public class Gruppe {

	private int idGruppe;
	private int status;
	private int mwert;
	private Vector<Button> buttons;
	Color farbe;

	public Gruppe(int idGruppe) {
		this.idGruppe = idGruppe;
		mwert = 0;
		status = 0;
		buttons = new Vector<Button>();
		farbe = new Color(zZahlFuerFarbe(),zZahlFuerFarbe(), 0);
	}

	public int getIdGruppe() {
		return idGruppe;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getMwert() {
		return mwert;
	}

	public void setMwert(int mwert) {
		this.mwert = mwert;
	}

	public Vector<Button> getButtons() {
		return buttons;
	}

	public void addButton(Button button) {
		buttons.add(button);
		button.setGruppe(idGruppe);
		mwert = mwert + button.getWert();
		if (mwert == 15) {
			for (int i = 0; i < buttons.size(); i++) {
				buttons.get(i).setVisible(false);
			}
			status = 1;
		} else {
			for (int i = 0; i < buttons.size(); i++) {
				buttons.get(i).setFarbe(farbe);
			}
		}
	}

	public void removeButton(Button button) {
		buttons.remove(button);
		button.setGruppe(0);
		mwert = mwert - button.getWert();
		button.setFarbe(null);
	}
	
	private int zZahlFuerFarbe(){
		int zZahl = (int) (Math.random() * 254) + 1;
		return zZahl;
	}

	@Override
	public String toString() {
		return "Gruppe [idGruppe=" + idGruppe + ", status=" + status
				+ ", mwert=" + mwert + ", buttons=" + buttons + "]";
	}

}
