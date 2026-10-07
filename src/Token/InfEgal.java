package Token;

public class InfEgal extends Token{

	public InfEgal() {
		super();
		this.setValeur("<=");
	}

	@Override
	public InfEgal copie() {
		InfEgal infEgal = new InfEgal();
		infEgal.setValeur(this.getValeur());
		infEgal.setNumLigne(this.getNumLigne());
		return infEgal;
	}
}
