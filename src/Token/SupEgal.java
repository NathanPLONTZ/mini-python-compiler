package Token;

public class SupEgal extends Token{

	public SupEgal() {
		super();
		this.setValeur(">=");
	}

	@Override
	public SupEgal copie() {
		SupEgal supEgal = new SupEgal();
		supEgal.setValeur(this.getValeur());
		supEgal.setNumLigne(this.getNumLigne());
		return supEgal;
	}
	
}
