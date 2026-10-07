package Token;

public class For extends Token{

	public For() {
		super();
		this.setValeur("for");
	}
	
	@Override
	public For copie() {
		For fr = new For();
		fr.setValeur(this.getValeur());
		fr.setNumLigne(this.getNumLigne());
		return fr;
	}

}

