package Token;

public class Str extends Token{

	public Str(String valeurToken) {
		super(valeurToken);
	}
	
	public Str() {
		super("Str pas de valeur");
	}
	
	@Override
	public Str copie() {
		Str str = new Str(this.getValeur());
		str.setNumLigne(this.getNumLigne());
		return str;
	}
}

