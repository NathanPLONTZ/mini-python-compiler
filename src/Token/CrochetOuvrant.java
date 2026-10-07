package Token;

public class CrochetOuvrant extends Token{

	public CrochetOuvrant() {
		super();
		this.setValeur("[");
	}
	
	@Override
	public CrochetOuvrant copie() {
		CrochetOuvrant co = new CrochetOuvrant();
		co.setValeur(this.getValeur());
		co.setNumLigne(this.getNumLigne());
		return co;
	}

}
