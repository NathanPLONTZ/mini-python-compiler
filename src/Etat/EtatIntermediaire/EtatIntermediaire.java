package Etat.EtatIntermediaire;


import Automate.Automate;
import Etat.Etat;

/**
 * A state the automaton can sit in while a lexeme is still being read.
 * {@link #action} picks the next state for the character just consumed.
 */
public abstract class EtatIntermediaire extends Etat {
	
	public EtatIntermediaire() {
		super();
	}



	public abstract void action(char c, Automate automate);
	
	
	
	
}
