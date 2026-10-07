package Token;

public class ParentheseOuvrante extends Token{

	public ParentheseOuvrante() {
		super();
		this.setValeur("(");
	}
	
	@Override
	public ParentheseOuvrante copie() {
		ParentheseOuvrante pO = new ParentheseOuvrante();
		pO.setValeur(this.getValeur());
		pO.setNumLigne(this.getNumLigne());
		return pO;
	}

}

