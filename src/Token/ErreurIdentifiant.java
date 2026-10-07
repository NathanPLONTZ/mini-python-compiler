package Token;

public class ErreurIdentifiant extends Erreur {

	public ErreurIdentifiant(int numLigne) {
		super(numLigne);
	}

	@Override
	public String getMessageErreur() {
		return "Erreur d'identifiant ligne "+getNumLigne()+" sur : "+this.getValeur();
	}
	
	@Override
	public ErreurIdentifiant copie() {
		ErreurIdentifiant erreurI = new ErreurIdentifiant(getNumLigne());
		return erreurI;
	}

}