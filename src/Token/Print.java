package Token;

public class Print extends Token {
	
	public Print() {
		super();
		this.setValeur("print");
	}
	
	@Override
	public Print copie() {
		Print print = new Print();
		print.setValeur(this.getValeur());
		print.setNumLigne(this.getNumLigne());
		return print;
	}
	
}
