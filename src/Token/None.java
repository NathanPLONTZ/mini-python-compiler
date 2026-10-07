package Token;

public class None extends Token{

	public None() {
		super();
		this.setValeur("None");
	}
	
	@Override
	public None copie() {
		None none = new None();
		none.setValeur(this.getValeur());
		none.setNumLigne(this.getNumLigne());
		return none;
	}

}
