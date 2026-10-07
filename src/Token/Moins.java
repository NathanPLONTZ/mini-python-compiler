package Token;

public class Moins extends Token{

	public Moins() {// On creation, check that the previous token is not a constant.
		super();
		this.setValeur("-");
	}
	
	@Override
	public Moins copie() {
		Moins moins = new Moins();
		moins.setValeur(this.getValeur());
		moins.setNumLigne(this.getNumLigne());
		return moins;
	}

}
