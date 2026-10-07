package Token;

public class ErreurOperateur extends Erreur {

	public ErreurOperateur(int numLigne) {
		super(numLigne);
	}

	@Override
	public String getMessageErreur() {
		return "Erreur de construction opération ligne :"+getNumLigne()+" sur : "+this.getValeur();
	}
	
	@Override
	public ErreurOperateur copie() {
		ErreurOperateur erreurO = new ErreurOperateur(getNumLigne());
		return erreurO;
	}
	
}