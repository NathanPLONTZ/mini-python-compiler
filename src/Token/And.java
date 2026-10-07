package Token;

public class And extends Token{

	public And() {
		super();
		this.setValeur("and");
	}

	@Override
	public And copie() {
		And and = new And();
		and.setValeur(this.getValeur());
		and.setNumLigne(this.getNumLigne());
		return and;
	}

}
