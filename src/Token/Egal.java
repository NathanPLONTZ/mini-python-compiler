package Token;

public class Egal extends Token{

	public Egal() {
		super();
		this.setValeur("=");
	}
	
	@Override
	public Egal copie() {
		Egal egal = new Egal();
		egal.setValeur(this.getValeur());
		egal.setNumLigne(this.getNumLigne());
		return egal;
	}

}
