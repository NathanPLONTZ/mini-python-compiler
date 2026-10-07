package Token;

public class ErreurInt extends Erreur {

	public ErreurInt(int numLigne) {
		super(numLigne);
	}

	@Override
	public String getMessageErreur() {
		return "Erreur d'entier ligne "+getNumLigne()+" sur : "+this.getValeur();
	}
	
	@Override
	public ErreurInt copie() {
		ErreurInt erreurI = new ErreurInt(getNumLigne());
		return erreurI;
	}
	
	

}
