package Token;


public class ErreurGuillemet  extends Erreur {

	public ErreurGuillemet(int numLigne) {
		super(numLigne);
	}

	@Override
	public String getMessageErreur() {
		return "Erreur guillemet ligne "+getNumLigne()+" sur : "+this.getValeur();
	}
	
	@Override
	public ErreurGuillemet copie() {
		ErreurGuillemet erreurG = new ErreurGuillemet(getNumLigne());
		return erreurG;
	}
	

}
