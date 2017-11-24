package D3_VererbungZeitschriftUebung;

public class HaftpflichtVersicherung extends Versicherung {
	
	
	double schadenSummeMax;

	public HaftpflichtVersicherung(int versicherungsNr, double monatsRate, int zahlungszyklus, double maxSumme) {
		super(versicherungsNr, monatsRate, zahlungszyklus);

		
		schadenSummeMax = maxSumme; 
		
	}

	public double getSchadenSummeMax() {
		return schadenSummeMax;
	}

	public void setSchadenSummeMax(double schadenSummeMax) {
		this.schadenSummeMax = schadenSummeMax;
	}

	@Override
	public String toString() {
		return super.toString() +"\nHaftpflichtVersicherung [schadenSummeMax=" + schadenSummeMax + "]";
	}
	
	
	

}
