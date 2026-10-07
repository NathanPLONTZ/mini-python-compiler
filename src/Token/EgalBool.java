package Token;

public class EgalBool extends Token {

	public EgalBool() {
		super();
		this.setValeur("==");
	}
	
	@Override
	public EgalBool copie() {
		EgalBool egb = new  EgalBool();
		egb.setValeur(this.getValeur());
		egb.setNumLigne(this.getNumLigne());
		return egb;
	}

}
