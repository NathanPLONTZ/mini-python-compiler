package Token;

public class ErreurPonctuation extends Erreur {

	public ErreurPonctuation(int numLigne) {
		super(numLigne);
	}

	@Override
	public String getMessageErreur() {
		return "Erreur de ponctuation ligne :"+getNumLigne()+" sur : "+this.getValeur();
	}
	
	@Override
	public ErreurPonctuation copie() {
		ErreurPonctuation erreurP = new ErreurPonctuation(getNumLigne());
		return erreurP;
	}
	
}