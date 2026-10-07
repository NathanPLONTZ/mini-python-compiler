package Token;

public class ParentheseFermante extends Token{

	public ParentheseFermante() {
		super();
		this.setValeur(")");
	}

	@Override
	public ParentheseFermante copie() {
		ParentheseFermante pF = new ParentheseFermante();
		pF.setValeur(this.getValeur());
		pF.setNumLigne(this.getNumLigne());
		return pF;
	}
}

