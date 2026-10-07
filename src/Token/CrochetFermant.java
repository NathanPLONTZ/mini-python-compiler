package Token;

public class CrochetFermant extends Token{

	public CrochetFermant() {
		super();
		this.setValeur("]");
	}
	
	@Override
	public CrochetFermant copie() {
		CrochetFermant cf = new CrochetFermant();
		cf.setValeur(this.getValeur());
		cf.setNumLigne(this.getNumLigne());
		return cf;
	}

}
