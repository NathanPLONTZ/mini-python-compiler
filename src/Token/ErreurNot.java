package Token;

public class ErreurNot extends Erreur {

	public ErreurNot(int numLigne) {
		super(numLigne);
	}

	@Override
	public String getMessageErreur() {
		return "Erreur de construction not ligne :"+getNumLigne()+" sur : "+this.getValeur();
	}
	

	@Override
	public ErreurNot copie() {
		ErreurNot erreurN = new ErreurNot(getNumLigne());
		return erreurN;
	}

}
