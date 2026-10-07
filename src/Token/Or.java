package Token;

public class Or extends Token{

	public Or() {
		super();
		this.setValeur("or");
	}
	
	@Override
	public Or copie() {
		Or or = new Or();
		or.setValeur(this.getValeur());
		or.setNumLigne(this.getNumLigne());
		return or;
	}

}