package D042_VererbungZugriffsrechte;

public abstract class Zeitung {
	
	
	
	private Redakteur derRedakteur;
	protected int id;
	

	public Zeitung(Redakteur rd){
		derRedakteur = rd;
		id = 0;
	}
	
	public abstract void test();
		


	//Delegationsmethode
	public String getRedakteurname() {
		return derRedakteur.getName();
	}

	@Override
	public String toString() {
		return "Zeitung [derRedakteur=" + derRedakteur + ", id=" + id + "]";
	}
	
	
	
	
	
	
}
