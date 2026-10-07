package Token;

public class Return extends Token {

	public Return() {
		super();
		this.setValeur("return");
	}
	
	@Override
	public Return copie() {
		Return ret = new Return();
		ret.setValeur(this.getValeur());
		ret.setNumLigne(this.getNumLigne());
		return ret;
	}

}
