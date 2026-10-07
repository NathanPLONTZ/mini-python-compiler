package Token;

public class Else extends Token{

	public Else() {
		super();
		this.setValeur("else");
	}
	
	@Override
	public Else copie() {
		Else els = new Else();
		els.setValeur(this.getValeur());
		els.setNumLigne(this.getNumLigne());
		return els;
	}

}

