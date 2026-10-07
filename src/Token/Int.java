package Token;

public class Int extends Token{

	public Int(String valeurToken) {
		super(valeurToken);
	}
	
	public Int() {
		super("Int pas de valeur");
	}
	
	@Override
	public Int copie() {
		Int integer = new Int(this.getValeur());
		integer.setNumLigne(this.getNumLigne());
		return integer;
	}
}

