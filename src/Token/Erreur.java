package Token;

public abstract class Erreur extends Token{

	private int numLigne;
	private String messageErreur;
	
	public Erreur(int numLigne) {
		super();
		this.numLigne = numLigne;
	}
	
	public int getNumLigne() {
		return numLigne;
	}
	
	public void setNumLigne(int numLigne) {
		this.numLigne = numLigne;
	}
	
	
	public abstract String getMessageErreur() ;
	
	public void setMessageErreur(String messageErreur) {
		this.messageErreur = messageErreur;
	}
	

}
