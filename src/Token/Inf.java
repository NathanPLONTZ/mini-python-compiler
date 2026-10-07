package Token;

public class Inf extends Token{

	public Inf() {
		super();
		this.setValeur("<");
	}

	@Override
	public Inf copie() {
		Inf inf = new Inf();
		inf.setValeur(this.getValeur());
		inf.setNumLigne(this.getNumLigne());
		return inf;
	}
	
}
