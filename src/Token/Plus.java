package Token;

public class Plus extends Token {

	public Plus() {
		super();
		this.setValeur("+");
	}

	@Override
	public Plus copie() {
		Plus plus = new Plus();
		plus.setValeur(this.getValeur());
		plus.setNumLigne(this.getNumLigne());
		return plus;
	}
	
}
