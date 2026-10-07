package Token;

public class Dollar extends Token{
	
	public Dollar() {
		super();
		this.setValeur("Dollar");
	}
	
	@Override
	public Dollar copie() {
		Dollar dollar = new Dollar();
		dollar.setValeur(this.getValeur());
		dollar.setNumLigne(this.getNumLigne());
		return dollar;
	}
	
}