package Token;

public class ErreurDivision extends Erreur {

	public ErreurDivision(int numLigne) {
		super(numLigne);
	}

	@Override
	public String getMessageErreur() {
		return "Erreur construction division ligne "+getNumLigne()+" sur : "+this.getValeur();
	}
	
	@Override
	public ErreurDivision copie() {
		ErreurDivision erreurD = new ErreurDivision(getNumLigne());
		return erreurD;
	}

}
