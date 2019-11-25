package A02a_Klassen_Uebung_wuerfel;

public class WuerfelFalschGewichtetException extends Exception {

	public WuerfelFalschGewichtetException() {
		super("Die Summe aller Gewichte eines Wuerfels muss 100 ergeben");
	}
}
