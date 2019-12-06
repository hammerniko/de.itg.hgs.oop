package Z2_NP2008A4_LoesungSchueler;

import java.awt.Color;
import java.util.Vector;

public class Steuerung {

	private Vector<Gruppe> dieGruppen;
	private int gruppenAnzahl;
	private Gui dieGui;
	private Button markedbtn = null;
	private Gruppe neueGruppe;

	public static void main(String[] args) {
		new Steuerung();
	}

	public Steuerung() {
		dieGui = new Gui(this);
		dieGruppen = new Vector<Gruppe>();
		gruppenAnzahl = 0;
	}

	public Steuerung getSteuerung() {
		return this;
	}

	public Gruppe getGruppe() {
		Gruppe dieGruppe = null;
		return dieGruppe;
	}

	public int zufallsZahl() {
		int zZahl = (int) (Math.random() * (10 - 1)) + 1;
		return zZahl;
	}

	public void btncheck(Button btn) {
		System.out.println("---Check Button Klick---");
		if (markedbtn == null) {
			System.out.print("1.Klick; ");
			if (btn.getGruppe() == 0) {
				System.out.print("Button nicht in Gruppe, markiert \n");
				markedbtn = btn;
				markedbtn.setFarbe(new Color(0, 0, 150));
				setAnzeige(4);
			} else {
				if (getGruppe(btn.getGruppe()).getStatus() == 0) {
					System.out.print("Button in Gruppe, markiert \n");
					markedbtn = btn;
					markedbtn.setFarbe(new Color(0, 0, 150));
					setAnzeige(4);
				}
			}
		} else {
			System.out.print("2.Klick; ");
			if (markedbtn.getGruppe() == 0) {
				System.out.print("1.Button nicht in Gruppe; ");
				if (btn.getGruppe() == 0) {
					System.out.print("2.Button nicht in Gruppe; ");
					if (reichweite(btn, markedbtn)) {
						if (wert(markedbtn.getWert(), btn.getWert())) {
							System.out.print("uebersteigt nicht 15 \n");
							neueGruppe(markedbtn, btn);
						} else {
							System.out.print("uebersteigt 15 \n");
							setAnzeige(6);
						}
					}
				} else {
					System.out.print("2.Button in Gruppe \n");
					reichweiteGruppe(btn, markedbtn);
				}
			} else {
				System.out.print("1.Button in Gruppe; ");
				if (btn.getGruppe() == 0) {
					System.out.print("2.Button nicht in Gruppe \n");
					reichweiteGruppe(markedbtn, btn);
				} else {
					System.out.print("2.Button in Gruppe \n");
					if (reichweite(markedbtn, btn))
						setAnzeige(5);
				}
			}
		}
	}

	private boolean reichweite(Button btn1, Button btn2) {
		int dSpalte = Math.abs(btn1.getSpalte() - btn2.getSpalte());
		int dZeile = Math.abs(btn1.getZeile() - btn2.getZeile());
		if (dSpalte > 1 || dZeile > 1) {
			setAnzeige(7);
			return false;
		} else if (dSpalte == 0 && dZeile == 0) {
			if (btn1.getGruppe() == 0) {
				btn1.setFarbe(null);
				System.out.println("Gleicher Button, nicht mehr makiert");
			} else {
				Gruppe gruppe = getGruppe(btn1.getGruppe());
				markedbtn.setFarbe(gruppe.farbe);
			}
			markedbtn = null;
			setAnzeige(0);
			System.out.println("Button nicht anliegend");
			return false;
		} else {
			System.out.println("Button anliegend");
			return true;
		}
	}

	private void reichweiteGruppe(Button btn1, Button btn2) {
		System.out.println("Check Gruppe anliegend");
		Gruppe gruppe = getGruppe(btn1.getGruppe());
		if (reichweite(btn1, btn2)) {
			System.out.println("Button anliegend");
			if (wert(gruppe.getMwert(), btn2.getWert())) {
				System.out.println("uebersteigt nicht 15");
				addbtn(btn2, gruppe);
			} else {
				System.out.println("uebersteigt 15");
				setAnzeige(6);
			}

		} else {
			System.out.println("Button nicht anliegend");
			Vector<Button> btns = gruppe.getButtons();
			System.out.println("Check andere Button in Gruppe");
			for (int i = 0; i < btns.size(); i++) {
				System.out.println("Button" + i + ":  ");
				if (reichweite(btns.get(i), btn2)) {
					System.out.print("anliegend; ");
					if (wert(gruppe.getMwert(), btn2.getWert())) {
						System.out.print("uebersteigt nicht 15");
						addbtn(btn2, gruppe);
						break;
					} else {
						System.out.print("uebersteigt 15");
						setAnzeige(6);
						break;
					}
				} else {
					System.out.println("nicht anliegend");
				}
			}
		}
	}

	private boolean wert(int wert1, int wert2) {
		if ((wert1 + wert2) > 15) {
			return false;
		} else {
			return true;
		}
	}

	private void neueGruppe(Button btn1, Button btn2) {
		System.out.println("-Neue Gruppe-");
		gruppenAnzahl++;
		neueGruppe = new Gruppe(gruppenAnzahl);
		dieGruppen.add(neueGruppe);
		addbtnErstellNeueGruppe(btn1, neueGruppe);
		addbtnErstellNeueGruppe(btn2, neueGruppe);
	}

	private void addbtn(Button btn, Gruppe gruppe) {
		System.out.println("-Button hinzugefuegt-");
		gruppe.addButton(btn);
		markedbtn = null;
		// ---------------------------------------------------------------------------------------------------------------------
		setAnzeige(2);
		// ---------------------------------------------------------------------------------------------------------------------
	}

	private void addbtnErstellNeueGruppe(Button btn, Gruppe gruppe) {
		System.out.println("-Button hinzugefuegt-");
		gruppe.addButton(btn);
		markedbtn = null;
		// ---------------------------------------------------------------------------------------------------------------------
		setAnzeige(1);
		// ---------------------------------------------------------------------------------------------------------------------
	}

	public void setAnzeige(int zahl) {
		dieGui.setAnzeige(zahl);
	}

	private Gruppe getGruppe(int idGruppe) {
		Gruppe gruppe = null;
		for (int i = 0; i < dieGruppen.size(); i++) {
			gruppe = dieGruppen.get(i);
			if (gruppe.getIdGruppe() == idGruppe)
				break;
		}
		return gruppe;
	}

	public void reset() {
		System.out.println("Reset");
		markedbtn = null;
		gruppenAnzahl = 0;
		dieGruppen.clear();
		dieGui.resetField();
		setAnzeige(0);
	}

}
