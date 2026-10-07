package Token;

public class Sup extends Token{

	public Sup() {
		super();
		this.setValeur(">");
	}
	
	@Override
	public Sup copie() {
		Sup sup = new Sup();
		sup.setValeur(this.getValeur());
		sup.setNumLigne(this.getNumLigne());
		return sup;
	}

}

