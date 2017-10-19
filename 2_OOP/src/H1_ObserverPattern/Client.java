package H1_ObserverPattern;
/**
 * Client.java
 */
public class Client {

	public static void main(String[] args) {
		
		// Erzeugung des Subjektes
		KonkretesSubjekt konkretesSubjekt = new KonkretesSubjekt();
		
		// Erzeugung des Beobachters. Dabei wird
		// das Subjekt uebergeben und registriert.
		KonkreterBeobachter konkreterBeobachter = new KonkreterBeobachter(konkretesSubjekt,"A");
		KonkreterBeobachter konkreterBeobachter2 = new KonkreterBeobachter(konkretesSubjekt,"B");
		KonkreterBeobachter konkreterBeobachter3 = new KonkreterBeobachter(konkretesSubjekt,"C");
		
		//Deregistrieren eines Beobachters
		konkretesSubjekt.removeBeobachter(konkreterBeobachter2);
		
		// Zustandsaenderung, Subjekt benachrichtigt
		// daraufhin alle registrierten Beobachter
		konkretesSubjekt.setState(1);
		konkretesSubjekt.setState(99);
	}
}
