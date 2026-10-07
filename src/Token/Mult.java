package Token;

public class Mult extends Token {

	public Mult() {
		super();
		this.setValeur("*");
	}
	
	@Override
	public Mult copie() {
		Mult mult = new Mult();
		mult.setValeur(this.getValeur());
		mult.setNumLigne(this.getNumLigne());
		return mult;
	}

}
