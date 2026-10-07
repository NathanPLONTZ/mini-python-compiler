package Token;

public class Def extends Token {

	public Def() {
		super();
		this.setValeur("def");
	}
	
	@Override
	public Def copie() {
		Def def = new Def();
		def.setValeur(this.getValeur());
		def.setNumLigne(this.getNumLigne());
		return def;
	}

}
