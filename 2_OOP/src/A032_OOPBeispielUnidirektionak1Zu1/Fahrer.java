package A032_OOPBeispielUnidirektionak1Zu1;

public class Fahrer {

	// Assoziation
	Auto dasAuto;

		
	
	// Verwaltungsmethoden
	public void linkAuto(Auto auto) {
		dasAuto = auto;
	}
	
	public void unlinkAuto() {
		dasAuto = null;
	}
	
	public Auto getAuto() {
		return dasAuto;
	}

	
	public void test() {
		if (dasAuto != null) {
			dasAuto.testmethode();
		}
	}

}
