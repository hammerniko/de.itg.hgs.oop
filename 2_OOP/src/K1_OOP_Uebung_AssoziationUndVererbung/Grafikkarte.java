package K1_OOP_Uebung_AssoziationUndVererbung;

public class Grafikkarte extends Bauteil{

	int anschluesseHDMI;
	int anschluesseVGA;
	int anschluesseDVI;
	int anschluesseDisplayPort;
	
	public int getAnschluesseDisplayPort() {
		return anschluesseDisplayPort;
	}

	public void setAnschluesseDisplayPort(int anschluesseDisplayPort) {
		this.anschluesseDisplayPort = anschluesseDisplayPort;
	}

	public Grafikkarte(Hersteller h, String bezeichnung) {
		super(h, bezeichnung);
		// TODO Auto-generated constructor stub
	}
	
	
	public int getAnschluesseHDMI() {
		return anschluesseHDMI;
	}

	public void setAnschluesseHDMI(int anschluesseHDMI) {
		this.anschluesseHDMI = anschluesseHDMI;
	}

	public int getAnschluesseVGA() {
		return anschluesseVGA;
	}

	public void setAnschluesseVGA(int anschluesseVGA) {
		this.anschluesseVGA = anschluesseVGA;
	}

	public int getAnschluesseDVI() {
		return anschluesseDVI;
	}

	public void setAnschluesseDVI(int anschluesseDVI) {
		this.anschluesseDVI = anschluesseDVI;
	}

	
	
}
