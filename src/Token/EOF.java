package Token;

public class EOF extends Token {

	public EOF() {
		super();
		this.setValeur("EOF");
	}

	@Override
	public EOF copie() {
		EOF eof = new EOF();
		eof.setValeur(this.getValeur());
		eof.setNumLigne(this.getNumLigne());
		return eof;
	}
	
}