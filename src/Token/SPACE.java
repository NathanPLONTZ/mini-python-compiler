package Token;

public class SPACE extends Token{

	public SPACE() {
		super();
		this.setValeur("SPACE");
	}
	
	@Override
	public SPACE copie() {
		SPACE space = new SPACE();
		space.setValeur(this.getValeur());
		space.setNumLigne(this.getNumLigne());
		return space;
	}

}

