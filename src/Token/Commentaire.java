package Token;

public class Commentaire extends Token{

	public Commentaire(String valeurToken) {
		super(valeurToken);
	}
	
	@Override
	public Commentaire copie() {
		Commentaire commentaire = new Commentaire(this.getValeur());
		commentaire.setNumLigne(this.getNumLigne());
		return commentaire;
	}

}

