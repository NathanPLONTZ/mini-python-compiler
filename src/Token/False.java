package Token;

public class False extends Token{

	public False() {
		super();
		this.setValeur("False");
	}
	
	@Override
	public False copie() {
		False fals = new False();
		fals.setValeur(this.getValeur());
		fals.setNumLigne(this.getNumLigne());
		return fals;
	}

}
