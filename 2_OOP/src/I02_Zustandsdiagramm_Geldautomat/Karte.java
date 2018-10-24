package I02_Zustandsdiagramm_Geldautomat;

public class Karte {
	
	int pin;
	boolean istGueltig;
	
	public Karte(int pin, boolean istGueltig) {
		this.pin = pin;
		this.istGueltig = istGueltig;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}
	
	

}
