package Etat.EtatErreur;

import Etat.Etat;
import Etat.EtatFinaux.EtatFinaux;

/**
 * An accepting state reached on a malformed lexeme. It consumes the rest of the
 * faulty text and emits an error token, so that the scan can keep going and
 * report further errors.
 */
public abstract class EtatErreur extends EtatFinaux{

	public EtatErreur() {
		super();
	}
	
	
	

}
