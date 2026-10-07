package Token;

public class Not extends Token{

	public Not() {
		super();
		this.setValeur("not");
	}
	
	@Override
	public Not copie() {
		Not not = new Not();
		not.setValeur(this.getValeur());
		not.setNumLigne(this.getNumLigne());
		return not;
	}

}
