package Token;

public class Pourcent extends Token {

	public Pourcent() {
		super();
		this.setValeur("%");
	}
	
	@Override
	public Pourcent copie() {
		Pourcent pourcent = new Pourcent();
		pourcent.setValeur(this.getValeur());
		pourcent.setNumLigne(this.getNumLigne());
		return pourcent;
	}

}
