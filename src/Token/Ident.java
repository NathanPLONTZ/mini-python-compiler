package Token;

public class Ident extends Token{

	public Ident(String valeurToken) {
		super(valeurToken);
	}
	
	public Ident() {
		super("Ident valeur vide");
	}
	
	@Override
	public Ident copie() {
		Ident ident= new Ident();
		ident.setValeur(this.getValeur());
		ident.setNumLigne(this.getNumLigne());
		return ident;
	}

}