package Token;

public class DeuxPoints extends Token{

	public DeuxPoints() {
		super();
		this.setValeur(":");
	}

	@Override
	public DeuxPoints copie() {
		DeuxPoints deuxP = new DeuxPoints();
		deuxP.setValeur(this.getValeur());
		deuxP.setNumLigne(this.getNumLigne());
		return deuxP;
	}
}

