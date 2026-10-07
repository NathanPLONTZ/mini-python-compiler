package Token;

public class In extends Token{

	public In() {
		super();
		this.setValeur("in");
	}

	@Override
	public In copie() {
		In in = new In();
		in.setValeur(this.getValeur());
		in.setNumLigne(this.getNumLigne());
		return in;
	}
}
