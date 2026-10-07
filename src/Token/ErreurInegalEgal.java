package Token;


public class ErreurInegalEgal extends Erreur {

	public ErreurInegalEgal(int numLigne) {
		super(numLigne);
	}

	@Override
	public String getMessageErreur() {
		return "Erreur construction inégalité/égalité ou affection ligne "+ getNumLigne()+" sur : "+this.getValeur();
	}
	
	@Override
	public ErreurInegalEgal copie() {
		ErreurInegalEgal erreurI = new ErreurInegalEgal(getNumLigne());
		return erreurI;
	}
}