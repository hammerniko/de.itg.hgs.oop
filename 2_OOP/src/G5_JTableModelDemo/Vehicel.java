package G5_JTableModelDemo;

//Das Vehikel ist eine total unabhaengige Klasse, die mit einer
//Tabelle eigentlich gar nichts zu tun hat.
class Vehicel{
	private String name;
	private int places, wheels;
	private boolean motor;

	public Vehicel( String name, int places, int wheels, boolean motor ){
		this.name = name;
		this.places = places;
		this.wheels = wheels;
		this.motor = motor;
	}

	public String getName(){ return name; }
	public int getPlaces(){ return places; }
	public int getWheels(){ return wheels; }
	public boolean hasMotor(){ return motor; }
}