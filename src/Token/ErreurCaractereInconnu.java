package Token;

public class ErreurCaractereInconnu extends Erreur {

	public ErreurCaractereInconnu(int numLigne) {
		super(numLigne);
	}

	@Override
	public String getMessageErreur() {
		return "Erreur caractère inconnu ligne "+this.getNumLigne()+" sur : "+this.getValeur();
	}
	
	@Override
	public ErreurCaractereInconnu copie() {
		ErreurCaractereInconnu erreurCI = new ErreurCaractereInconnu(getNumLigne());
		return erreurCI;
	}
	

}
