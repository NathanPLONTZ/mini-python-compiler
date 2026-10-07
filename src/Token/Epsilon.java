package Token;

public class Epsilon extends Token{
	
	public Epsilon() {
		super();
		this.setValeur("Epsilon");
	}
	
	@Override
	public Epsilon copie() {
		Epsilon epsilon = new Epsilon();
		epsilon.setValeur(this.getValeur());
		epsilon.setNumLigne(this.getNumLigne());
		return epsilon;
	}

}
