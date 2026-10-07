package Token;

public class True extends Token{

	public True() {
		super();
		this.setValeur("True");
	}
	
	@Override
	public True copie() {
		True tru = new True();
		tru.setValeur(this.getValeur());
		tru.setNumLigne(this.getNumLigne());
		return tru;
	}

}
