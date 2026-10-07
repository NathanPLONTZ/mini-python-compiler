package Token;

public class NotEgal extends Token {

	public NotEgal() {
		super();
		this.setValeur("!=");
	}
	
	@Override
	public NotEgal copie() {
		NotEgal notEgal = new NotEgal();
		notEgal.setValeur(this.getValeur());
		notEgal.setNumLigne(this.getNumLigne());
		return notEgal;
	}

}
