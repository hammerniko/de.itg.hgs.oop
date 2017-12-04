package Z6_HP2013_ShutTheBox;

public class Wuerfel {
	
	private int aLetzterWurf;
	private int neuerWurf;
	
	public int wuerfeln() {
		aLetzterWurf = neuerWurf;
		neuerWurf = (int)(Math.random()*6+1);
		return neuerWurf;
	}
	
	public int gibLetzterWurf() {
		return aLetzterWurf;
	}

}
