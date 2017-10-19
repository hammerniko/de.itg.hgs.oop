package H1_ObserverPattern;
/**
 * KonkreterBeobachter.java
 */
public class KonkreterBeobachter implements Beobachter {

	private String name;
	private KonkretesSubjekt konkretesSubjekt;

	public KonkreterBeobachter(KonkretesSubjekt konkretesSubjekt, String name) {
		this.konkretesSubjekt = konkretesSubjekt;
		this.name = name;
		// Durchfuehrung der Registrierung beim uebergebenen Subjekt
		this.konkretesSubjekt.addBeobachter(this);
	}
	
	@Override
	public void update() {
		int newState = konkretesSubjekt.getState();
		// ...auf neuen Status reagieren
		System.out.println(name+": hat ein Update erhalten:"+newState);
	}
}
