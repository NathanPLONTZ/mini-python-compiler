package Token;

public class ErreurIndentation extends Erreur {

	public ErreurIndentation(int numLigne) {
		super(numLigne);
	}

	@Override
	public String getMessageErreur() {
		int ligneIndentationErreur=getNumLigne()+1;
		return "Erreur d'indentation ligne "+ligneIndentationErreur;
	}

	@Override
	public ErreurIndentation copie() {
		ErreurIndentation erreurI = new ErreurIndentation(getNumLigne());
		return erreurI;
	}
}