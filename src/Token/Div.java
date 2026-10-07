package Token;

public class Div extends Token {

	public Div() {
		super();
		this.setValeur("//");
	}

	@Override
	public Div copie() {
		Div div = new Div();
		div.setValeur(this.getValeur());
		div.setNumLigne(this.getNumLigne());
		return div;
	}
}
