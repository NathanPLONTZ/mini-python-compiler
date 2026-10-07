package Token;

public class BEGIN extends Token {

	public BEGIN() {
		super();
		this.setValeur("BEGIN");
	}
	
	@Override
	public BEGIN copie() {
		BEGIN begin = new BEGIN();
		begin.setValeur(this.getValeur());
		begin.setNumLigne(this.getNumLigne());
		return begin;
	}

}