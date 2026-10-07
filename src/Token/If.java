package Token;

public class If extends Token{

	public If() {
		super();
		this.setValeur("if");
	}
	
	@Override
	public If copie() {
		If iff = new If();
		iff.setValeur(this.getValeur());
		iff.setNumLigne(this.getNumLigne());
		return iff;
	}

}
