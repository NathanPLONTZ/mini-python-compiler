package Token;

public class Virgule extends Token{

	public Virgule() {
		super();
		this.setValeur(",");
	}

	@Override
	public Virgule copie() {
		Virgule virgule = new Virgule();
		virgule.setValeur(this.getValeur());
		virgule.setNumLigne(this.getNumLigne());
		return virgule;
	}
	
}
